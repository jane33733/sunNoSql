package com.sun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sun.dao.ProductDao;
import com.sun.service.ProductService;
import com.sun.vo.db.Product;

/**
 * The Class ImpeachServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	/** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    
    @Autowired
    private ProductDao productDao = new ProductDao();
    
    private Gson gson = new Gson();

	@Override
	public List<Product> queryAll() {
		List<Product> resultList = new ArrayList<Product>();
		try {
			resultList = productDao.query();
			System.out.println(gson.toJson(resultList));
		} catch (Exception e) {
			LOGGER.debug("search fail : {}",e);
		}
		
		return resultList;
	}

	@Override
	public boolean addProduct(Product product) {
		boolean result = false;
		ProductDao productDao = new ProductDao();
		result = productDao.insert(product);
		return result;
	}

	@Override
	public String deleteProduct(final String pId) {
		boolean result = false;
		ProductDao productDao = new ProductDao();
		result = productDao.delete(pId);
		
		return (result ? pId : "");
	}
	
}
