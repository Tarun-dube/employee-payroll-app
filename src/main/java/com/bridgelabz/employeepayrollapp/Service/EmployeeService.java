package com.bridgelabz.employeepayrollapp.Service;




import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    // Create and return an Employee model
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDepartment(employeeDTO.getDepartment());
        return employee;
    }

    // Update and return an Employee model
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(id); // Simulate updating an existing employee
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDepartment(employeeDTO.getDepartment());
        return employee;
    }

    // Return a default Employee model (for demonstration)
    public Employee getEmployeeById(Long id) {
        return new Employee(id, "Default Employee", 0.0, "Default Department");
    }
}