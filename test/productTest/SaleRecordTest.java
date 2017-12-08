package productTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;
import com.sun.service.ProductService;
import com.sun.service.SaleRecordService;
import com.sun.service.impl.ProductServiceImpl;
import com.sun.service.impl.SaleRecordServiceImpl;
import com.sun.vo.db.Product;
import com.sun.vo.db.SaleRecord;
import com.sun.vo.output.ProductInfoVO;
import com.sun.vo.output.SaleRecordReportInfoVO;
import com.sun.vo.transfer.SaleRecordQueryVO;

public class SaleRecordTest {

	private String testExcel = "D:\\testCase.xlsx";
	private Gson gson = new Gson();
	
	public void create20million() {
		SaleRecordService ss = new SaleRecordServiceImpl();
		
		LocalDateTime nowStamp = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println("計算資料新稱需要的時間" + dtf.format(nowStamp));
		
		ss.randomAddSale();
		
		nowStamp = LocalDateTime.now();
		System.out.println("結束時間" + dtf.format(nowStamp));
		
	}
	
	private int randomWithRange(int min, int max){
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	

	public void queryReport() {
		SaleRecordService saleService = new SaleRecordServiceImpl();
		SaleRecordQueryVO queryVO = new SaleRecordQueryVO();
		
		LocalDate localDate = LocalDate.now();//For reference
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = localDate.format(formatter);
		
		queryVO.setStartDate( LocalDate.parse("2017-01-01", formatter) );
		queryVO.setEndDate( LocalDate.parse("2017-12-31", formatter) );
		List<SaleRecordReportInfoVO> result = saleService.queryTopAndLast(queryVO);
		System.out.println("所有產品" + gson.toJson(result));
	}
	
	public void deleteAll() {
		SaleRecordService ss = new SaleRecordServiceImpl();
		ss.deleteAllSale();
		System.out.println("end");
	}
	
//	public List<BoardVO> getTestData() {
//	
//	List<BoardVO> dataList = new ArrayList<>();
//	try {
//		FileInputStream fis = new FileInputStream(new File(testExcel));
//		
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sh = wb.getSheetAt(0);
//		int colNum = sh.getRow(0).getLastCellNum();
//		int rowNum = sh.getLastRowNum()+1;
//		
//		for (int i = 1; i < rowNum; i++) {
//			XSSFRow row = sh.getRow(i);
//			BoardVO inputVO = new BoardVO();
//			inputVO.setPlant(row.getCell(0).getStringCellValue());
//			inputVO.setStartTime( Integer.parseInt(row.getCell(1).getStringCellValue()) );
//			inputVO.setLine(row.getCell(2).getStringCellValue());
//			inputVO.setQty( (int)(row.getCell(3).getNumericCellValue()));
//			inputVO.setPn(row.getCell(4).getStringCellValue());
//			inputVO.setModel(row.getCell(5).getStringCellValue());
//			dataList.add(inputVO);
////			for (int j = 1; j < colNum; j++) {
////				XSSFCell col = row.getCell(j);
////			}
//		}
//	
//		System.out.println("[test data]"+gson.toJson(dataList));
//		
////		fun.addCalendar(inputList, userId);
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return dataList;
//}

	
}
