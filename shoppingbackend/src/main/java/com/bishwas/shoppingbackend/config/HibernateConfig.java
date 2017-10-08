package com.bishwas.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.bishwas.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";

	
	@Bean
	private DataSource getDataSource(){
		
		BasicDataSource dataSource = new BasicDataSource();
		
		// Provding the database connection infromation
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}
	
	//SessionFactory bean will be avaiable
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.bishwas.shoppingbackend.dto");
		
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		
		
		
		return null;
	}
	
	@Bean
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory){
		
		HibernateTransactionManager tran = new HibernateTransactionManager();
		
		return tran;
	}
	
	
}
