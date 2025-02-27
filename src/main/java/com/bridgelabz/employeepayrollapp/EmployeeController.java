package com.bridgelabz.employeepayrollapp;





import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;

import com.bridgelabz.employeepayrollapp.Service.EmployeeService;
import com.bridgelabz.employeepayrollapp.entity.Employee;

import com.bridgelabz.employeepayrollapp.service.EmployeeService;
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

    @GetMapping
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.addEmployee(employeeDTO);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody EmployeeDTO employeeDTO){
        return employeeService.udpateEmployee(id,employeeDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return  employeeService.deleteEmployee(id);

    }

}
