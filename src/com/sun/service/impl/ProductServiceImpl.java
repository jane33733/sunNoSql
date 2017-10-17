package com.sun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sun.dao.ProductDao;
import com.sun.request.vo.ProductQueryVO;
import com.sun.respose.vo.ProductInfoVO;
import com.sun.service.ProductService;
import com.sun.vo.db.Product;

/**
 * The Class ImpeachServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	/** The Constant LOGGER. */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProductServiceImpl.class);
    
    @Autowired
    private ProductDao productDao;
    private Gson gson = new Gson();

	@Override
	public List<ProductInfoVO> search(final int id) {
		List<Product> searchList = new ArrayList<Product>();
		List<ProductInfoVO> pInfoList = new ArrayList<ProductInfoVO>();
		try {
					
//			searchList = productDao.getAll();
			
			
		} catch (Exception e) {
			LOGGER.debug("search fail : {}",e);
		}
		
		return pInfoList;
	}

	@Override
	public List<Product> addProduct(Product product) {
		List<Product> productList = null;
		ProductDao productDao = new ProductDao();
		productList = productDao.insert(product);
		System.out.println(gson.toJson(productList));
		
		return productList;
	}
	
	
}
