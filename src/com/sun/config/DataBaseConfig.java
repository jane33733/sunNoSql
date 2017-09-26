

package com.sun.config;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ImportResource(locations = {"file:WebContent/WEB-INF/applicationContext.xml",
		"file:WebContent/WEB-INF/context-dispatcher.xml", "file:WebContent/WEB-INF/spring-views.xml"})
public class DataBaseConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		final org.apache.commons.dbcp.BasicDataSource dataSource = new BasicDataSource();
		
        Properties properties = new Properties();
        
        try {

            ClassLoader loader = Thread.currentThread().getContextClassLoader();   
            InputStream stream = loader.getResourceAsStream("jdbc.properties");        
            properties.load(stream);

            dataSource.setDriverClassName(properties.getProperty("db.driver"));
            dataSource.setUrl(properties.getProperty("db.url"));
            dataSource.setUsername(properties.getProperty("db.username"));
            dataSource.setPassword(properties.getProperty("db.password"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		final LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.scanPackages("com.sun.entity");
		sessionBuilder.addProperties(this.getHibernateProperties());

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		final HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "false");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return properties;
	}
}
