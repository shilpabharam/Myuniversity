package com.codecoop.myuniversity.core;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

	@Value("#{myuniversityDataSource}")
	private DataSource myuniversityDataSource;

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		Properties props = new Properties();
		props.put("hibernate.dialect", MySQLDialect.class.getName());
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.show_sql", "true");

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setPackagesToScan(new String[] { "com.codecoop.myuniversity.core.domain" });		
		sessionFactory.setHibernateProperties(props);
		sessionFactory.setDataSource(this.myuniversityDataSource);
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		return new HibernateTransactionManager(sessionFactoryBean().getObject());
	}

}
