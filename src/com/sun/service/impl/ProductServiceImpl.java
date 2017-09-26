package com.sun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.dao.ProductDao;
import com.sun.entity.Product;
import com.sun.request.vo.ProductQueryVO;
import com.sun.respose.vo.ProductInfoVO;
import com.sun.service.ProductService;

/**
 * The Class ImpeachServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	/** The Constant LOGGER. */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProductServiceImpl.class);
    
    @Autowired
    private ProductDao productDao;

	@Override
	public List<ProductInfoVO> search(final int id) {
		List<Product> searchList = new ArrayList<Product>();
		List<ProductInfoVO> pInfoList = new ArrayList<ProductInfoVO>();
		try {
					
			searchList = productDao.getAll();
			for (Product product : searchList) {
				ProductInfoVO productInfoVO = new ProductInfoVO();
				productInfoVO.setId(product.getId());
				productInfoVO.setName(product.getName());
				productInfoVO.setPrice(product.getPrice());
				productInfoVO.setCreateTime(product.getCreateTime());
				pInfoList.add(productInfoVO);
			}
			
			
		} catch (Exception e) {
			LOGGER.debug("search fail : {}",e);
		}
		
		return pInfoList;
	}

	@Override
	public List<Product> searchByCondition(ProductQueryVO queryVO) {
		List<Product> productList = null;
		
		productList = productDao.getByPrice(queryVO);
		
		return productList;
	}
	
	
}
