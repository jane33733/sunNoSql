package com.sun.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sun.dao.ProductDao;
import com.sun.dao.SaleRecordDao;
import com.sun.service.SaleRecordService;
import com.sun.vo.db.Product;
import com.sun.vo.db.SaleRecord;
import com.sun.vo.output.SaleRecordReportInfoVO;
import com.sun.vo.transfer.MonthRptRsVO;
import com.sun.vo.transfer.SaleRecordQueryVO;
import com.sun.vo.transfer.SrReportIdVO;


@Service
public class SaleRecordServiceImpl implements SaleRecordService {
	
	/** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SaleRecordServiceImpl.class);
    
    private SaleRecordDao saleRecordDao = new SaleRecordDao();
    
    private Gson gson = new Gson();
    private int max = 9999;
    private int min = 1;

	public List<SaleRecord> queryAll() {
		List<SaleRecord> resultList = new ArrayList<>();
		try {
			//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			resultList = saleRecordDao.query();
			System.out.println(gson.toJson(resultList));
		} catch (Exception e) {
			LOGGER.debug("search fail : {}",e);
		}
		
		return resultList;
	}

	@Override
	public List<SaleRecordReportInfoVO> queryTopAndLast(SaleRecordQueryVO queryVO) {
		List<SaleRecordReportInfoVO> resultList = new ArrayList<>();
		List<MonthRptRsVO> dbList = null;
		SaleRecordDao saleRecordDao = new SaleRecordDao();
		ProductDao productDao = new ProductDao();
		
		// add product name TODO
		dbList = saleRecordDao.queryTopAndLast(queryVO);
		List<Product> pList = productDao.query();
		for (Product p : pList) {
			SaleRecordReportInfoVO infoVO = new SaleRecordReportInfoVO();
			infoVO.setpId(p.getpId());
			infoVO.setpName(p.getName());
			
			List<String> dateList = new ArrayList<>();
			List<Integer> totalList = new ArrayList<>();
			for (MonthRptRsVO rsVO : dbList) {
				SrReportIdVO srReportId = rsVO.getSrReportId();
				if (p.getpId().equals(srReportId.getpId())) {
					dateList.add(srReportId.getYear() + "-" + srReportId.getMonth());
					totalList.add(rsVO.getTotal());
				}else {
					break;
				}
			}
			
			infoVO.setDateList(dateList);
			infoVO.setTotalList(totalList);
			resultList.add(infoVO);
		}
		LOGGER.info("top and last report {}", gson.toJson(resultList));
		return resultList;
	}
	
	@Override
	public boolean addSaleList(List<SaleRecord> productList) {
		boolean result = false;
		SaleRecordDao saleRecordDao = new SaleRecordDao();
		result = saleRecordDao.insertBatch(productList);
		return result;
	}

	@Override
	public boolean deleteAllSale() {
		boolean result = false;
		try {
			SaleRecordDao saleRecordDao = new SaleRecordDao();
			result = saleRecordDao.deleteAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean randomAddSale() {
		boolean result = true;
		int insetCount = 0;
		SaleRecordDao saleRecordDao = new SaleRecordDao();
		List<SaleRecord> saleList = null;
		for (int i = 0; i < 1; i++) {
			 saleList = this.randomSaleRecord();
			if (result) {
				saleList = this.randomSaleRecord();
				result = saleRecordDao.insertBatch(saleList);
				insetCount += 100000;
			}else {
				break;
			}
		}
		
		LOGGER.info("success insert {} rows", insetCount);
		return result;
	}
	
	private List<SaleRecord> randomSaleRecord(){
		List<SaleRecord> productList = new ArrayList<>();
		Random rn = new Random();
		int randomPid = 0;
		int randomAmount = 0;
		long minDay = LocalDate.of(2017, 1, 1).toEpochDay();
	    long maxDay = LocalDate.of(2017, 12, 31).toEpochDay();
	    long randomDay = 1L;
		
		for (int i = 0; i < 10000; i++) {
			randomPid = rn.nextInt(6);
			randomAmount = rn.nextInt(200) + 1;
			randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
			
			SaleRecord saleRecord = new SaleRecord();
			saleRecord.setSrId(this.generateSrId());
			saleRecord.setpId("A00" + randomPid);
			saleRecord.setAmount(randomAmount);
			Date date = Date.from( (LocalDate.ofEpochDay(randomDay)).atStartOfDay(ZoneId.systemDefault()).toInstant());
            saleRecord.setSaleDate( date );

			productList.add(saleRecord);
		}
		return productList;
	}
	
	private String generateSrId() {
		String srID = "";
		DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyyMMddHHmmssSSS");
		srID = dtf.print(new DateTime()).substring(2);
		
		Random rn = new Random();
		int randomSerial = rn.nextInt(max - min + 1) + min;
		
		srID = srID + String.format("%04d", randomSerial);
		return srID;
	}
}
