package com.iba.assignment.controller;


import com.iba.assignment.model.Employee;
import com.iba.assignment.services.EmployeeService;
import com.iba.assignment.services.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employee")
    public List<Employee> getEmployee() { return employeeService.getEmployees();}


    @PostMapping("/saveEmployee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        try {
            employeeService.createEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Added the Employee");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/update-employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable(value = "id") Long employeeId, @RequestBody Employee employeeDetails) {
        try {
            employeeService.updateEmployee(employeeId, employeeDetails);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully Updated Employee Details");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        try {
            employeeService.deleteEmployee(employeeId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully Deleted the Employee");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }

    }

}
