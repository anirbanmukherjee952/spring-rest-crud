package com.sandbox.springdemo;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan
@PropertySource("classpath:application.properties")
public class WebConfig implements WebMvcConfigurer {
	
	private Logger logger;
		
	@Autowired
	private Environment env;
	
	public WebConfig() {
		this.logger = Logger.getLogger(this.getClass().getName());
	}
	
	// need a helper method 
	// read environment property and convert to int
	private int getIntProperty(String propName) {
		return Integer.parseInt(env.getProperty(propName));
	}

	@Bean 
	public DataSource dataSource() {
		
		// create connection pool
		ComboPooledDataSource theDataSource = new ComboPooledDataSource();
		
		// set the jdbc driver
		try {
			theDataSource.setDriverClass("com.mysql.jdbc.Driver");		
		}
		catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// log url and user ... just to make sure we are reading the data
		logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
		
		// set database connection props
		theDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		theDataSource.setUser(env.getProperty("jdbc.user"));
		theDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		theDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		theDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		theDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));		
		theDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return theDataSource;

	}

	// need a helper method 
	// to get hibernate properties
	private Properties getHibernateProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return props;				
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		// create session factorys
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		// set the properties
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
		
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
		
	}
	
//	@Bean
//	public ViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setPrefix("/WEB-INF/view/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/WEB-INF/resources/");
	}
	
}
