package com.esprit.PI.GestionVoyage.config;

import com.esprit.PI.GestionVoyage.entities.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee emp = new Employee();
        emp.setName(rs.getString("name"));
        emp.setName(rs.getString("email"));
        return emp;
    }
}
