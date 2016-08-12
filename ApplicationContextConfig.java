package com.niit.shoppingcart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;

@Configuration
@ComponentScan("com.niit.shoppingcart.config")
@EnableTransactionManagement


public class ApplicationContextConfig {
	
	@Bean(name = "dataSource")                               
	public DataSource getDataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/ankita");

	    dataSource.setUsername("sa");
	    dataSource.setPassword(" ");
	    return dataSource;
	}

	private Properties getHibernateProperties() {
		  Properties properties = new Properties();
		  properties.put("hibernate.show_sql", "true");   //to display the queries ,,,,can be given false if u want to hide the queries
		  properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		  properties.put("hibernate.hbm2ddl.auto", "update");
		  return properties;
		}



		@Autowired   //automatically bean is created n injected
		@Bean(name = "SessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource)  {
		  LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);  //sessionBuilder can b any other name too
		  sessionBuilder.addProperties(getHibernateProperties());
		  sessionBuilder.addAnnotatedClass(Category.class);
		  sessionBuilder.addAnnotatedClass(Supplier.class);
		  return sessionBuilder.buildSessionFactory();
		}

		@SuppressWarnings("deprecation")
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
		  SessionFactory sessionFactory) {
		HiberanateTransactionManager transactionManager = new HiberanateTransactionManager(sessionFactory);  //should be same name as bean name of session factory
		return transactionManager;
		}

}
