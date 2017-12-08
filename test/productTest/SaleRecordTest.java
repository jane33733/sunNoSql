package productTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.google.gson.Gson;
import com.sun.service.SaleRecordService;
import com.sun.service.impl.SaleRecordServiceImpl;
import com.sun.vo.output.SaleRecordReportInfoVO;
import com.sun.vo.transfer.SaleRecordQueryVO;

public class SaleRecordTest {

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
		//String formattedString = localDate.format(formatter);
		
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
	

	
}
