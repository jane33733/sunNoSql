package mytest;

import org.junit.Test;

import com.google.gson.Gson;

import productTest.ProductTest;
import productTest.SaleRecordTest;

public class TestEntrance {

	private Gson gson = new Gson();
	
	@Test
	public void test() {
		
//		ProductTest pt = new ProductTest();
//		pt.insert();
//		pt.query();
//		pt.delete();
//		pt.create5();
		
		SaleRecordTest srTest = new SaleRecordTest();
//		srTest.create20million();
		srTest.queryReport();
//		srTest.deleteAll();
		
	}

}
