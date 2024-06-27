package com.example.TaskOnHrDB.Services.PLSQLServices;

import com.example.TaskOnHrDB.Models.Employee;
import com.example.TaskOnHrDB.Models.EmployeePLSQL;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<EmployeePLSQL> {
    @Override
    public EmployeePLSQL mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeePLSQL employee = new EmployeePLSQL();
        employee.seteId(rs.getLong("e_id"));
        employee.seteName(rs.getString("e_name"));
        employee.setSalary(rs.getDouble("salary"));
        employee.setAddress(rs.getString("address"));
        employee.setPhoneNo(rs.getString("phone_no"));
        employee.setDepartment_no(rs.getLong("department_no"));
        employee.setDepartment_name(rs.getString("deparment_name"));
        return employee;
    }
}
