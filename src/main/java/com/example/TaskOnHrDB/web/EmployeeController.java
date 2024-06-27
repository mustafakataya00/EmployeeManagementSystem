package com.example.TaskOnHrDB.web;

import com.example.TaskOnHrDB.ErrorHandlers.AlreadyExistsException;
import com.example.TaskOnHrDB.ErrorHandlers.ErrorResponse;
import com.example.TaskOnHrDB.ErrorHandlers.NotFoundException;
import com.example.TaskOnHrDB.Models.Department;
import com.example.TaskOnHrDB.Models.Employee;
import com.example.TaskOnHrDB.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id) {
        try {
            Employee author = employeeService.getEmployeeById(id);
            return ResponseEntity.ok(author);
        } catch (NotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
    @GetMapping("/department/{departmentNo}")
    public List<Employee> getEmployeesByDepartmentNo(@PathVariable("departmentNo") Long departmentNo) {
        // Fetch department based on departmentNo from repository
        Department department = new Department();
        department.setDepartmentNo(departmentNo);

        return employeeService.getEmployeesByDepartment(department);
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee newEmployee , BindingResult result)
    {
        if(result.hasErrors())
        {
            Map<String, String> errors = result.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            return ResponseEntity.badRequest().body(errors);
        }
        try{
            Employee employee = employeeService.createEmployee(newEmployee);
            return ResponseEntity.status(HttpStatus.CREATED).body(employee);

        }catch(AlreadyExistsException e){
            ErrorResponse errorResponse = new ErrorResponse((e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
    /**
     * DELETE /api/employees/{id} - Delete employee by id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        catch (NotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    /**
     * PUT /api/employees/{id} - Update employee by id (replace)
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePutEmployee(@PathVariable Long id, @RequestBody Employee updatedAuthor) {
        try {
            Employee employee = employeeService.updateEmployee(id, updatedAuthor);
            return ResponseEntity.ok(employee);
        } catch (NotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
    /**
     * PATCH /api/employees/{id} - Update employee by id (partial update)
     */
    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePatchEmployee(@PathVariable Long id, @RequestBody Employee updatedAuthor) {
        try {
            Employee employee = employeeService.patchEmployee(id, updatedAuthor);
            return ResponseEntity.ok(employee);
        } catch (NotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}
