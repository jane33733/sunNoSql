package com.sun.service;

import java.util.List;

import com.sun.vo.db.Product;
import com.sun.vo.output.ProductInfoVO;

public interface ProductService {
	
	List<ProductInfoVO> queryAll();
	
	boolean addProduct(final Product product);
	
	boolean addProductList(final List<Product> productList);
	
	String deleteProduct(final String pId);
	
}
