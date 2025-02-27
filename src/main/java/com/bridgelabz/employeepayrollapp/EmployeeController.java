package com.bridgelabz.employeepayrollapp;





import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.Service.EmployeeService;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // GET - Fetch an employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // POST - Create a new employee
    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    // PUT - Update an existing employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }





}
