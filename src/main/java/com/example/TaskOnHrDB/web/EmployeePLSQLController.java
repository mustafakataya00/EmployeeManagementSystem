package com.example.TaskOnHrDB.web;

import com.example.TaskOnHrDB.ErrorHandlers.AlreadyExistsException;
import com.example.TaskOnHrDB.ErrorHandlers.ErrorResponse;
import com.example.TaskOnHrDB.ErrorHandlers.NotFoundException;
import com.example.TaskOnHrDB.Models.Department;
import com.example.TaskOnHrDB.Models.Employee;
import com.example.TaskOnHrDB.Models.EmployeePLSQL;
import com.example.TaskOnHrDB.Services.PLSQLServices.PLSQLEmployeeService;
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
@RequestMapping("/api/plsqlEmployees")
public class EmployeePLSQLController {

    private PLSQLEmployeeService employeeService;

    @Autowired
    public EmployeePLSQLController(PLSQLEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<EmployeePLSQL> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


     @PostMapping
     public ResponseEntity<?> createEmployee(@RequestBody EmployeePLSQL newEmployee)
     {
         try{
             EmployeePLSQL employee = employeeService.createEmployee(newEmployee);
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
    public ResponseEntity<?> updatePutEmployee(@PathVariable Long id, @RequestBody EmployeePLSQL updatedemployee) {
        try {
            EmployeePLSQL employee = employeeService.updateEmployee(id, updatedemployee);
            return ResponseEntity.ok(employee);
        } catch (NotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

}

