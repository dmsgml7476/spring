package com.springStudy1.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("peh");
		ds.setPassword("1234");
		ds.setUrl("jdbc:mysql://localhost:3306/peh");
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbc(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	
}


/*
	Configuration
		스프링 프레임워크에서 빈 등록, 의존성 주입, 환경설정을 관리하는 방법 (자바 기반)

	스프링 프레임워크에서 설정하는 방법은 xml, java기반, annotation 기반이 있다.
*/