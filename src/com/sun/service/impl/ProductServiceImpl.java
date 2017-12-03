package com.sun.service.impl;

import java.time.format.DateTimeFormatter;
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
import com.sun.vo.output.ProductInfoVO;

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
	public List<ProductInfoVO> queryAll() {
		List<Product> resultList = new ArrayList<Product>();
		List<ProductInfoVO> infoList = new ArrayList<>();
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			resultList = productDao.query();
			for (Product product : resultList) {
				ProductInfoVO infoVO = new ProductInfoVO();
				infoVO.setpId(product.getpId());
				infoVO.setName(product.getName());
				infoVO.setPrice(product.getPrice().intValue());
				infoVO.setCreateTime(formatter.format(product.getCreateTime()));
				infoList.add(infoVO);
			}
			System.out.println(gson.toJson(resultList));
		} catch (Exception e) {
			LOGGER.debug("search fail : {}",e);
		}
		
		return infoList;
	}

	@Override
	public boolean addProduct(Product product) {
		boolean result = false;
		ProductDao productDao = new ProductDao();
		result = productDao.insert(product);
		return result;
	}
	
	@Override
	public boolean addProductList(List<Product> productList) {
		boolean result = false;
		ProductDao productDao = new ProductDao();
		result = productDao.insertBatch(productList);
		return result;
	}

	@Override
	public String deleteProduct(final String pId) {
		boolean result = false;
		ProductDao productDao = new ProductDao();
		result = productDao.delete(pId);
		
		return (result ? pId : "");
	}

	@Override
	public boolean randomAddProduct() {
		boolean result = true;
		int insetCount = 0;
		ProductDao productDao = new ProductDao();
		List<Product> productList = null;
		while(result) {
			productList = this.randomProduct();
			result = productDao.insertBatch(productList);
		}
		LOGGER.info("success insert {} rows", insetCount);
		return result;
	}
	
	private List<Product> randomProduct(){
		List<Product> productList = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			Product p = new Product();
			
			productList.add(p);
		}
		return productList;
	}
}
