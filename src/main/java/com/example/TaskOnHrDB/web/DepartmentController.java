package com.example.TaskOnHrDB.web;

import com.example.TaskOnHrDB.Models.Department;
import com.example.TaskOnHrDB.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/all")
    public List<Department> getAllEmployees() {
        return departmentService.getAllDepartments();
    }
}
