package com.example.TaskOnHrDB.Services;

import com.example.TaskOnHrDB.Models.Department;
import com.example.TaskOnHrDB.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class DepartmentService {

        private DepartmentRepository departmentRepository;

        @Autowired
        public DepartmentService(DepartmentRepository departmentRepository) {
            this.departmentRepository = departmentRepository;
        }

        public List<Department> getAllDepartments() {
            return departmentRepository.findAll();
        }
    }
