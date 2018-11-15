package com.tsystems.tshop.config;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.Properties;

@Configuration
public class DatabaseConfig {
    private static final String dbName = "shopexperiments";
    private static final String dbUser = "root";
    private static final String dbPass = "mmm333";

	@Bean
	public DataSource dataSource() {
        Properties properties = new Properties();
        properties.setProperty("serverTimezone","UTC");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/"+dbName);
        dataSource.setConnectionProperties(properties);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPass);
		return dataSource;
	}

	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
}
