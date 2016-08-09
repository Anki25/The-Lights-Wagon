package com.niit.shoppingcart.config;
import java.util.Properties;

@Configuration
@ComponentScan("com.niit.shoppingcart.config")
@EnableTransactionManagement


public class ApplicationContextConfig {
	
	@Bean(name = "dataSource")                               
	public DataSource getDataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/niitdb");

	    dataSource.setUsername("sa");
	    dataSource.setPassword("sa");
	    return dataSource;
	}


}
