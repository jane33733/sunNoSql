package mytest;

import org.junit.Test;

import com.google.gson.Gson;

import productTest.ProductTest;

public class TestEntrance {

	private Gson gson = new Gson();
	
	@Test
	public void test() {
		
		ProductTest pt = new ProductTest();
//		pt.insert();
		pt.query();
//		pt.delete();
//		pt.create5();
		
	}

}
