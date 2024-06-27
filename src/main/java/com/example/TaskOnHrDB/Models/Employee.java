package com.example.TaskOnHrDB.Models;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "e_id")
    private Long eId;

    @Column(name = "e_name")
    private String eName;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_no")
    private String phoneNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_no")
    private Department department;

    public Employee() {
    }

    public Employee(Long eId, String eName, Double salary, String address, String phoneNo, Department department) {
        this.eId = eId;
        this.eName = eName;
        this.salary = salary;
        this.address = address;
        this.phoneNo = phoneNo;
        this.department = department;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department.setDepartmentNo(department);
    }
}
