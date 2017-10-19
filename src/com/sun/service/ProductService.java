package com.sun.service;

import java.util.List;

import com.sun.respose.vo.ProductInfoVO;
import com.sun.vo.db.Product;

public interface ProductService {
	
	List<ProductInfoVO> search();
	
	List<Product> addProduct(final Product product);
	
	boolean deleteProduct(final String pId);
	
	
	
}
