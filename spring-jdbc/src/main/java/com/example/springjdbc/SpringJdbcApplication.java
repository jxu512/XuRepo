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

@SpringBootApplication
@Service
@EnableTransactionManagement
public class SpringJdbcApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	EmployeeService employeeService;
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//employeeService.update1();
		employeeService.updateNotWorkingInternalCall();
	}

}
