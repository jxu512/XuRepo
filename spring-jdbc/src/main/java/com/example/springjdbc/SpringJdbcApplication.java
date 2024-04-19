package com.example.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Company> companies = jdbcTemplate.query("select * from Company", new CompanyRowMapper());
		companies.forEach(System.out::println);

		jdbcTemplate.update("update Company set employees=employees+1000 where name='CapitalOne'");
		companies = jdbcTemplate.query("select * from Company", new CompanyRowMapper());
		companies.forEach(System.out::println);
	}

}
