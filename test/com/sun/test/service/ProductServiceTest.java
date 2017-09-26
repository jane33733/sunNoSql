package com.sun.test.service;

import com.sun.service.impl.ProductServiceImpl;
import com.sun.dao.ProductDao;
import com.sun.entity.Product;
import com.sun.request.vo.ProductQueryVO;
import com.sun.respose.vo.ProductInfoVO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/context-dispatcher.xml")

public class ProductServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(ProductServiceTest.class);

	@Mock
	@Autowired
	private ProductDao productDao;
	
	@InjectMocks
	@Autowired
    private ProductServiceImpl productService;

	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testSeachRaiseException() throws Exception {
		log.info("###### In testSeachRaiseException runing #######");
		
		// Mock DOA thenThrow
//		when(productDao.getAll()).thenThrow(new Exception("Mock DOA Exception"));
//		doThrow(new Exception()).when(productDao).getAll();
		when(productDao.getAll()).thenReturn(null);
		
		// Go to test
		List<ProductInfoVO> testTargetList = productService.search(0);
		log.info("=== Checking: Is result ecpected ? ===");
		assertTrue(testTargetList.isEmpty());
		log.info(">> Yes. Checking pass.");
	}
		
	@Test
	public void testSeachCanGenAllProduct() throws Exception {
			
		log.info("###### In testSeachCanGenAllProduct runing #######");
		
		List<Product> mockSearchList = new ArrayList<Product>();
		java.util.Date now = new java.util.Date();

		// Mock DOA return result
		mockSearchList.add(new Product("0", "P1", new BigDecimal("100"), now));
		mockSearchList.add(new Product("0", "P2", new BigDecimal("200"), now));
		mockSearchList.add(new Product("0", "P3", new BigDecimal("300"), now));
		when(productDao.getAll()).thenReturn(mockSearchList); 
		
		// Go to test
		List<ProductInfoVO> testTargetList = productService.search(0);
		
		// Expected result
		List<ProductInfoVO> expectedList = new ArrayList<ProductInfoVO>();
		expectedList.add(new ProductInfoVO("0", "P1", new BigDecimal("100"), now));
		expectedList.add(new ProductInfoVO("0", "P2", new BigDecimal("200"), now));
		expectedList.add(new ProductInfoVO("0", "P3", new BigDecimal("300"), now));

		// Result checking
		log.info("=== Checking 1: Is size of result ecpected ? ===");
		assertThat(testTargetList, hasSize(3));
		log.info(">> Yes. Checking pass.");
		
		log.info("=== Checking 2: Is value of result ecpected ? ===");
		for(int i = 0; i < testTargetList.size(); i++) {
			log.info(String.format(">> Check obj_%d", i));
			
			assertTrue((testTargetList.get(i) instanceof ProductInfoVO));
			ProductInfoVO targetObj = testTargetList.get(i);
			ProductInfoVO expectedObj = expectedList.get(i);
			
			// Use reflection to check object's property
			List<String> methodName = Arrays.asList("getId", "getName", "getPrice", "getCreateTime");
			for(String method: methodName) {
				Method testMethod = ProductInfoVO.class.getMethod(method, null);
				log.info(String.format("Check value via Function: %s", method));
//				log.info(String.format("targetObj: %s, expectedObj: %s",
//										testMethod.invoke(targetObj).toString(), 
//										testMethod.invoke(expectedObj).toString()));
				assertEquals(testMethod.invoke(targetObj), testMethod.invoke(expectedObj));
	        }
			log.info("----------");
		} 
	}
	
	@Test
	public void testSearchByCondition() throws Exception {
		List<Product> mockSearchList = new ArrayList<Product>();
		java.util.Date now = new java.util.Date();
		
		ProductQueryVO queryVO = new ProductQueryVO();

		// Mock DOA return result
		mockSearchList.add(new Product("0", "P1", new BigDecimal("100"), now));
		mockSearchList.add(new Product("0", "P2", new BigDecimal("200"), now));
		mockSearchList.add(new Product("0", "P3", new BigDecimal("300"), now));
		when(productDao.getByPrice(queryVO)).thenReturn(mockSearchList); 
		
		// Go to test
		List<Product> testTargetList = productService.searchByCondition(queryVO);
		
		// Result checking
		log.info("=== Checking 1: Is size of result ecpected ? ===");
		assertThat(testTargetList, hasSize(3));
		log.info(">> Yes. Checking pass.");
		
		log.info("=== Checking 2: Is result ecpected ? ===");
		assertEquals(mockSearchList, testTargetList);
		log.info(">> Yes. Checking pass.");
	
	}

}
