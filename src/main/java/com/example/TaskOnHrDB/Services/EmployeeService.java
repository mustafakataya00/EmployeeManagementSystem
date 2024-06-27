package com.example.TaskOnHrDB.Services;
import com.example.TaskOnHrDB.ErrorHandlers.AlreadyExistsException;
import com.example.TaskOnHrDB.ErrorHandlers.NotFoundException;
import com.example.TaskOnHrDB.Models.Department;
import com.example.TaskOnHrDB.Models.Employee;
import com.example.TaskOnHrDB.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee createEmployee(Employee newEmployee) {
        if (employeeRepository.existsByEName(newEmployee.geteName())) {
            throw new AlreadyExistsException("Task with title '" + newEmployee.geteName() + "' already exists.");
        }
        return employeeRepository.save(newEmployee);
    }

    public void deleteEmployee(Long id){
        if (!employeeRepository.existsById(id)) {
            throw new NotFoundException("employee with id '" + id + "' does not exists.");
        }
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.seteName(updatedEmployee.geteName());
            return employeeRepository.save(employee);
        } else {
            throw new NotFoundException("employee with id " + id + " not found.");
        }
    }
    public Employee patchEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            if (updatedEmployee.geteName() != null) {
                employee.seteName(updatedEmployee.geteName());
            }
            return employeeRepository.save(employee);
        } else {
            throw new NotFoundException("employee with id " + id + " not found.");
        }
    }
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("employee not found with id " + id));
    }
    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByEName(name)
                .orElseThrow(() -> new NotFoundException("employee not found with name " + name));
    }
    public List<Employee> getEmployeesByDepartment(Department departmentNo) {
        return employeeRepository.findByDepartment(departmentNo);
    }
}
