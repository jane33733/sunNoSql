package com.sun.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDao {
	
    @Autowired
    protected SessionFactory sessionFactory;
    

}
