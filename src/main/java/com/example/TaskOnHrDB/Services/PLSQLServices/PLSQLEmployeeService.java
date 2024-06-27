package com.example.TaskOnHrDB.Services.PLSQLServices;

import com.example.TaskOnHrDB.Models.Employee;
import com.example.TaskOnHrDB.Models.EmployeePLSQL;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.NumberUp;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PLSQLEmployeeService {
    private final JdbcTemplate jdbcTemplate;

    public PLSQLEmployeeService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<EmployeePLSQL> getAllEmployees() {
        String sql = "SELECT * FROM TABLE(EMPLOYEE_PKG_SPEC_MOSTAFA.findall())";

        List<EmployeePLSQL> employees = jdbcTemplate.query(sql, new EmployeeRowMapper());

        return employees;
    }
    public EmployeePLSQL createEmployee(EmployeePLSQL newEmployee) {
        String sql = "DECLARE " +
                "    v_employee employee_pkg_spec_mostafa.employee_rec; " +
                "BEGIN " +
                "    v_employee := employee_pkg_spec_mostafa.create_employee( " +
                "                    p_e_name => ?, " +
                "                    p_salary => ?, " +
                "                    p_address => ?, " +
                "                    p_phone_no => ?, " +
                "                    p_department_no => ? " +
                "                ); " + "END;";

        Object[] params = {
                newEmployee.geteName(),
                newEmployee.getSalary(),
                newEmployee.getAddress(),
                newEmployee.getPhoneNo(),
                newEmployee.getDepartment_no(),
        };

        jdbcTemplate.update(sql, params);

        // Assuming you want to return the newEmployee object itself after creation
        return newEmployee;
    }

    public void deleteEmployee(Long id) {

        Object[] params = { id };
        jdbcTemplate.update("DECLARE" +
                "    v_success BOOLEAN;" +
                "BEGIN" +
                "    v_success := EMPLOYEE_PKG_SPEC_MOSTAFA.delete_employee(?);" +
                "     END;", params);
    }

    public EmployeePLSQL updateEmployee(Long id, EmployeePLSQL updatedEmployee) {

        Object[] params = { id, updatedEmployee.geteName(), updatedEmployee.getSalary(), updatedEmployee.getAddress(), updatedEmployee.getPhoneNo(), updatedEmployee.getDepartment_no() };
        String sql = "DECLARE " +
                "    v_employee employee_pkg_spec_mostafa.employee_rec; " +
                "BEGIN " +
                "    v_employee := employee_pkg_spec_mostafa.update_employee( " +
                "                    p_e_id => ?, "+
                "                    p_e_name => ?, " +
                "                    p_salary => ?, " +
                "                    p_address => ?, " +
                "                    p_phone_no => ?, " +
                "                    p_department_no => ? " +
                "                ); " + "END;";

        jdbcTemplate.update(sql, params);

        return updatedEmployee;
    }
}
