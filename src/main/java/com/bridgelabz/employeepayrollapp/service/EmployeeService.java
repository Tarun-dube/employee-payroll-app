package com.bridgelabz.employeepayrollapp.Service;

import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class EmployeeService {

private final List<Employee> employeeList=new ArrayList<>();
private Long nextId=1L;

//create and store employee
    public Employee addEmployee(EmployeeDTO employeeDTO){
        log.debug("Saving employee: {}", employeeDTO);

        Employee employee=new Employee();
        employee.setId(nextId);
        employee.setName(employeeDTO.getName());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSalary(employeeDTO.getSalary());
        employeeList.add(employee);
        nextId++;
        return employee;
    }
    //get all employee
    public List<Employee> getEmployee(){
        log.debug("Retrieving all employees from database...");

        return employeeList;
    }
    //get employee by id
    public Employee getEmployeeById(Long id){
        Optional<Employee> employee = employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst();
        return employee.orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }
    //update list
    public Employee udpateEmployee(Long id, EmployeeDTO employeeDTO){
        Employee employee=getEmployeeById(id);
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDepartment(employeeDTO.getDepartment());
        return employee;
    }
    //delete employee
    public String deleteEmployee(Long id){
        Employee employee=getEmployeeById(id);

        employeeList.remove(employee);
        return  "deleted successfully";
    }
}
