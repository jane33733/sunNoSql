package com.sun.test.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.sun.config.DataBaseConfig;
import com.sun.dao.ProductDao;
import com.sun.entity.Product;
import com.sun.request.vo.ProductQueryVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DataBaseConfig.class })
@EnableTransactionManagement
@Transactional
public class ProductDaoTest {

	@Autowired
	private ProductDao pDao;
	
	private ProductQueryVO pqVO;
	Integer priceTop;
	Integer priceBtm;

	@Test
	@Rollback(true)
	public void testGetByPriceAll() {
		priceTop = 500;
		priceBtm = 0;
		pqVO = new ProductQueryVO();
		pqVO.setPriceTop(priceTop);
		pqVO.setPriceBottom(priceBtm);
		List<Product> productList = pDao.getByPrice(pqVO);
		assertThat(productList, hasSize(3));
	}
	
	@Test
	@Rollback(true)
	public void testGetByPriceOne() {
		priceTop = 299;
		priceBtm = 289;
		pqVO = new ProductQueryVO();
		pqVO.setPriceTop(priceTop);
		pqVO.setPriceBottom(priceBtm);
		List<Product> resultList = pDao.getByPrice(pqVO);
		assertThat(resultList, hasSize(1));
	}
	
	@Test
	@Rollback(true)
	public void testGetByPriceNull() {
		priceTop = 100;
		priceBtm = 0;
		pqVO = new ProductQueryVO();
		pqVO.setPriceTop(priceTop);
		pqVO.setPriceBottom(priceBtm);
		List<Product> resultList = pDao.getByPrice(pqVO);
		assertThat(resultList, hasSize(0));
	}

}