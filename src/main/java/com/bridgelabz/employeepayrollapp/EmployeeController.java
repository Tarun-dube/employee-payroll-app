package com.bridgelabz.employeepayrollapp;





import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    //in memory data store
    private final Map<Long,Employee> dataStore=new HashMap<>();
    private Long nextId=1L;//simulate auto increament id

    // gell all datat
    @GetMapping
    public Map<Long,Employee> getAllData(){
        return dataStore;
    }
    //get by id
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id){
        return dataStore.getOrDefault(id,new Employee(-1L, "Not Found", "N/A", 0));
    }
    // add data
    @PostMapping
    public String addData(@RequestBody EmployeeDTO employeeDTO){
        Employee employee=new Employee(nextId,employeeDTO.getName(),employeeDTO.getDepartment(),employeeDTO.getSalary());
        dataStore.put(nextId,employee);
        nextId++;
        return "data added successfully";
    }
    //update data
    @PutMapping("/{id}")
    public String updateData(@PathVariable Long id,@RequestBody EmployeeDTO employeeDTO){
        if(dataStore.containsKey(id)){
            Employee employee=dataStore.get(id);
            employee.setName(employeeDTO.getName());
            employee.setDepartment(employeeDTO.getDepartment());
            employee.setSalary(employeeDTO.getSalary());


            dataStore.put(id,employee);
            return "data updated successfully";
        }
        return "data not found for "+id;
    }

    //delete data
    @DeleteMapping("/{id}")
    public String deleteData(@PathVariable Long id){
       if(dataStore.containsKey(id)) {
           dataStore.remove(id);
           return "data deleted successfully";
       }
       else return "employee not found for ID: "+id;
    }





}
