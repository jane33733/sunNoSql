package com.sun.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sun.entity.Product;
import com.sun.request.vo.ProductQueryVO;

@Transactional
@Repository
public class ProductDao extends BaseDao{

	
	@SuppressWarnings("unchecked")
	public List<Product> getAll() {
		List<Product> productList =  new ArrayList<>();
        final StringBuilder str = new StringBuilder();
        str.append(" FROM Product ");

        final Query query = this.sessionFactory.getCurrentSession().createQuery(str.toString());
//        final Query query = this.sessionFactory.getCurrentSession().createQuery(str.toString());
//        query.setString("email", email);
//        query.setInteger("status", status.getValue());

        productList = (List<Product>)query.list();
        
        
        return productList;

    }
	
	public List<Product> getByTime() {
		List<Product> productList =  new ArrayList<>();
		final StringBuilder str = new StringBuilder();
		str.append(" SELECT * FROM sun_product ");
		
		final Query query = this.sessionFactory.getCurrentSession().createSQLQuery(str.toString());
//        final Query query = this.sessionFactory.getCurrentSession().createQuery(str.toString());
//        query.setString("email", email);
//        query.setInteger("status", status.getValue());
		
		List resultList = query.list();
		
		for (int i = 0; i < resultList.size(); i++) {
			Product product = (Product)resultList.get(i);
			productList.add(product);
		}
		
		return productList;
		
	}
	
	public List<Product> getByPrice(ProductQueryVO queryVO) {
		//TODO
		List<Product> productList =  new ArrayList<>();
		String whereAnd = "WHERE";
		final StringBuilder str = new StringBuilder();
		
		str.append(" SELECT * FROM sun_product ");
		
		if (queryVO.getPriceBottom() != null) {
			str.append(whereAnd).append(" price > :priceBottom ");
			whereAnd = "AND";
		}
		if (queryVO.getPriceTop() != null) {
			str.append(whereAnd).append(" price < :priceTop ");
			whereAnd = "AND";
		}
		
		SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(str.toString());
		query.setParameter("priceBottom", queryVO.getPriceBottom());
		query.setParameter("priceTop", queryVO.getPriceTop());
		query.addEntity(Product.class);
		
		@SuppressWarnings("rawtypes")
		List resultList = query.list();
		
		for (int i = 0; i < resultList.size(); i++) {
			Product product = (Product)resultList.get(i);
			productList.add(product);
		}
		
		return productList;
		
	}
}
