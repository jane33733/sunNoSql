package com.sun.service;

import java.util.List;

import com.sun.vo.db.Product;

public interface ProductService {
	
	List<Product> queryAll();
	
	boolean addProduct(final Product product);
	
	boolean addProductList(final List<Product> productList);
	
	String deleteProduct(final String pId);
	
}
