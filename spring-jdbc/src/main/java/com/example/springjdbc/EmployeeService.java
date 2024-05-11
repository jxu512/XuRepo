package com.example.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void updateNotWorkingInternalCall() {
		update1();
	}
	// Method has to be public for proxy
	@Transactional
	public void update1() {
		List<Company> companies = jdbcTemplate.query("select * from Company where name like 'C%'", new CompanyRowMapper());
		companies.forEach(System.out::println);

		jdbcTemplate.update("update Company set employees=employees+5 where name='Citigroup'");
		add5();			// Included in transaction
		add5Error();	// Included in transaction, error causing rollback
		companies = jdbcTemplate.query("select * from Company where name like 'C%'", new CompanyRowMapper());
		companies.forEach(System.out::println);

	}

	@Transactional
	private void update2() {
		List<Company> companies = jdbcTemplate.query("select * from Company", new CompanyRowMapper());
		//companies.forEach(System.out::println);

		jdbcTemplate.update("update Company set employees=employees+5 where namex='CapitalOne'");
		companies = jdbcTemplate.query("select * from Company where name like 'C%'", new CompanyRowMapper());
		companies.forEach(System.out::println);

	}

	private void add5() {
		jdbcTemplate.update("update Company set employees=employees+5 where name='Citigroup'");

	}
	private void add5Error() {
		jdbcTemplate.update("update Company set employees=employees+5 where namex='Citigroup'");

	}
}
