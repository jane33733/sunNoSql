package com.sun.service;

import java.util.List;

import com.sun.respose.vo.ProductInfoVO;
import com.sun.vo.db.Product;

public interface ProductService {
	
	/**
	 * Search.
	 *
	 * @param impeachSearchVO the impeach search VO
	 * @return the list
	 */
	List<ProductInfoVO> search(final int id);
	
	
	List<Product> addProduct(final Product product);
	
	
	
}
