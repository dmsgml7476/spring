package com.springStudy1.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SchoolDAO {
	private final JdbcTemplate jdbc;
	
	
	@Autowired
	public SchoolDAO(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
}
