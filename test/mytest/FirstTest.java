package mytest;

import org.junit.Test;

import com.sun.config.DataBaseConfig;

public class FirstTest {

	@Test
	public void test() {
		DataBaseConfig dbc = new DataBaseConfig();
		dbc.getDataSource();
	}

}
