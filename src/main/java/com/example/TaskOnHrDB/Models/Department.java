package com.example.TaskOnHrDB.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_no")
    private Long departmentNo;

    @Column(name = "deparment_name")
    private String departmentName;

    public Department() {
    }

    public Department(Long departmentNo, String departmentName) {
        this.departmentNo = departmentNo;
        this.departmentName = departmentName;
    }

    public void setDepartmentNo(Long departmentNo) {
        this.departmentNo = departmentNo;
    }

    public Long getDepartmentNo() {
        return departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

