package com.bridgelabz.employeepayrollapp;





import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final Map<Long,String> dataStore=new HashMap<>();

    // gell all datat
    @GetMapping
    public Map<Long,String> getAllData(){
        return dataStore;
    }
    //get by id
    @GetMapping("/{id}")
    public String getById(@PathVariable Long id){
        return dataStore.getOrDefault(id,"value not found for "+id);
    }
    // add data
    @PostMapping
    public String addData(@RequestParam Long id,@RequestParam String name){
        dataStore.put(id,name);
        return "data added successfully";
    }
    //update data
    @PutMapping("/{id}")
    public String updateData(@PathVariable Long id,@RequestParam String name){
        if(dataStore.containsKey(id)){
            dataStore.put(id,name);
            return "data updated successfully";
        }
        return "data not found for "+id;
    }

    //delete data
    @DeleteMapping("/{id}")
    public String deleteData(@PathVariable Long id){
        dataStore.remove(id);
        return "data deleted successfully";
    }





}
