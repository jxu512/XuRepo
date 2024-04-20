package com.example.springjdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyRowMapper implements RowMapper<Company> {

    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        Company company = new Company();
        company.setName(rs.getString("name"));
        company.setLocation(rs.getString("location"));
        company.setNumberOfEmployees(rs.getInt("employees"));
        return company;
    }
}
