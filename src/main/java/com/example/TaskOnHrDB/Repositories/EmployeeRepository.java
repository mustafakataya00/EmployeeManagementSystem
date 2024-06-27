package com.example.TaskOnHrDB.Repositories;

import com.example.TaskOnHrDB.Models.Department;
import com.example.TaskOnHrDB.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByDepartment(Department departmentNo);

    boolean existsByEName(String geteName);
    Optional<Employee> findByEName(String eName);

}
