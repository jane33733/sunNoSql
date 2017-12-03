package com.sun.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sun.dao.SaleRecordDao;
import com.sun.service.SaleService;
import com.sun.vo.db.SaleRecord;


/**
 * The Class ImpeachServiceImpl.
 */
@Service
public class SaleServiceImpl implements SaleService {
	
	/** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SaleServiceImpl.class);
    
    @Autowired
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
	public boolean addSale(SaleRecord product) {
		boolean result = false;
		SaleRecordDao saleRecordDao = new SaleRecordDao();
		result = saleRecordDao.insert(product);
		return result;
	}
	
	@Override
	public boolean addSaleList(List<SaleRecord> productList) {
		boolean result = false;
		SaleRecordDao saleRecordDao = new SaleRecordDao();
		result = saleRecordDao.insertBatch(productList);
		return result;
	}

	@Override
	public String deleteSale(final String pId) {
		boolean result = false;
		SaleRecordDao saleRecordDao = new SaleRecordDao();
		result = saleRecordDao.delete(pId);
		
		return (result ? pId : "");
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
			saleRecord.setSaleDate(LocalDate.ofEpochDay(randomDay));
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
