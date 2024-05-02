package com.example.springjdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlainJavaApplication {

    public static void main(String[] args) {
        PlainJavaApplication app = new PlainJavaApplication();
        app.testUsingDatasource();
        app.testUsingDriverManager();
    }

    private void testUsingDatasource() {
        DataSource ds = new JdbcConfig().mysqlDataSource();
        try {
            Connection con = ds.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Company");
            List<Company> companies = new ArrayList<>();
            while (rs.next()) {
                CompanyRowMapper rowMapper = new CompanyRowMapper();
                companies.add(rowMapper.mapRow(rs, 1));
            }
            companies.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void testUsingDriverManager() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "jeffrey1");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Company");
            List<Company> companies = new ArrayList<>();
            while (rs.next()) {
                CompanyRowMapper rowMapper = new CompanyRowMapper();
                companies.add(rowMapper.mapRow(rs, 1));
            }
            companies.forEach(System.out::println);
            Company c = companies.get(0);
            int a=123_51_1234_1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
