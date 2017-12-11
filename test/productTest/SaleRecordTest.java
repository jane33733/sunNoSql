package productTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;

import com.google.gson.Gson;
import com.sun.service.SaleRecordService;
import com.sun.service.impl.SaleRecordServiceImpl;
import com.sun.vo.output.SaleRecordReportInfoVO;
import com.sun.vo.transfer.SaleRecordQueryVO;

public class SaleRecordTest {

	private Gson gson = new Gson();
	
	public void create200thousand() {
		SaleRecordService ss = new SaleRecordServiceImpl();
		
		LocalDateTime nowStamp = LocalDateTime.now();
		DateTime startTime = new DateTime();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println("開始時間" + dtf.format(nowStamp));
		
		ss.randomAddSale();
		
		nowStamp = LocalDateTime.now();
		DateTime endTime = new DateTime();
		System.out.println("結束時間" + dtf.format(nowStamp));
		
		Period p = new Period(startTime, endTime);
		System.out.println("計算新增20萬筆資料需要的時間: " + p.getHours() + "小時 " + p.getMinutes() + "分鐘 " + p.getSeconds() + "秒");
		//0小時 0分鐘 47秒
		
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
		DateTime startTime = new DateTime();
		List<SaleRecordReportInfoVO> result = saleService.queryTopAndLast(queryVO);
		System.out.println("所有產品" + gson.toJson(result));
		DateTime endTime = new DateTime();
		
		Period p = new Period(startTime, endTime);
		System.out.println("計算查詢20萬筆資料需要的時間: " + p.getHours() + "小時 " + p.getMinutes() + "分鐘 " + p.getSeconds() + "秒");
		//0小時 0分鐘 2秒
	}
	
	public void deleteAll() {
		SaleRecordService ss = new SaleRecordServiceImpl();
		ss.deleteAllSale();
		System.out.println("end");
	}
	

	
}
