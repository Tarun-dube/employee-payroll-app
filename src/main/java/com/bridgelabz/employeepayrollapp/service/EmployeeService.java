package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Transactional
    public Employee updateEmployee(Long id,Employee updateEmployee) {
        return repository.findById(id).map(employee -> {
            employee.setName(updateEmployee.getName());
            employee.setDepartment(updateEmployee.getDepartment());
            employee.setSalary(updateEmployee.getSalary());
            return repository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }
    @Transactional
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

}
