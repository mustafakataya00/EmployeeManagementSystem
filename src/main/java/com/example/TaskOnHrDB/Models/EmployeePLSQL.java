package com.example.TaskOnHrDB.Models;

public class EmployeePLSQL {
    private Long eId;
    private String eName;
    private Double salary;
    private String address;
    private String phoneNo;
    private Long department_no;
    private String department_name;

    public EmployeePLSQL() {
    }

    public EmployeePLSQL(Long eId, String eName, Double salary, String address, String phoneNo, Long department_no , String department_name) {
        this.eId = eId;
        this.eName = eName;
        this.salary = salary;
        this.address = address;
        this.phoneNo = phoneNo;
        this.department_no = department_no;
        this.department_name =department_name;
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

    public Long getDepartment_no() {
        return department_no;
    }

    public void setDepartment_no(Long department_no) {
        this.department_no = department_no;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}
