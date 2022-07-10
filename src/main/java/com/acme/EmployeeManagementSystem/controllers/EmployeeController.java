package com.acme.EmployeeManagementSystem.controllers;
import com.acme.EmployeeManagementSystem.model.Employee;
import com.acme.EmployeeManagementSystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;
    @PostMapping("/addemployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @GetMapping("/listemployee")
    public Iterable<Employee> listEmployee() {
        return employeeService.findAll();
    }
    @PutMapping("/updateemployee")
    public ResponseEntity<Employee> update(@RequestBody Employee employee)
    {
        if(employeeService.findById(employee.getEmpID()).isPresent())
            return new ResponseEntity(employeeService.save(employee), HttpStatus.OK);
        else
            return new ResponseEntity(employee,HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/deleteemployee/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteById(id);
    }

    @GetMapping("/getemployeebyid/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Integer id) {
        return employeeService.findById(id);
    }

    public @GetMapping("/wrong")
    Employee enteredWrongUrl() {
        throw new javax.validation.ValidationException("Something went wrong----Incorrect URL");
    }
}

