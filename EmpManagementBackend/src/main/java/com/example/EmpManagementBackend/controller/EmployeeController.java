package com.example.EmpManagementBackend.controller;

import com.example.EmpManagementBackend.exception.ResourceNotFoundException;
import com.example.EmpManagementBackend.model.Employee;
import com.example.EmpManagementBackend.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        Employee employee=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(("Employee not found with id:"+id)));
        return  employee;
    }
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee emp){
        Employee employee=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(("Employee not found with id:"+id)));
        if(emp.getFirstName()!=null){
            employee.setFirstName(emp.getFirstName());
        }
        if(emp.getLastName()!=null){
            employee.setLastName(emp.getLastName());
        }
        if(emp.getEmailId()!=null){
            employee.setEmailId(emp.getEmailId());
        }
        Employee updatedEmployee=employeeRepo.save(employee);
        return updatedEmployee;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteEmployee(@PathVariable  Long id){
        Employee emp=employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not found with id:"+id));
        employeeRepo.delete(emp);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;



    }


}
