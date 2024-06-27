package com.example.TaskOnHrDB.Repositories;

import com.example.TaskOnHrDB.Models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
