package com.ems.employeemanagement.rest;

import com.ems.employeemanagement.dao.EmployeeDAO;
import com.ems.employeemanagement.entity.Employee;
import com.ems.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.findEmployeeById(employeeId);
        return employee;
    }

    @PostMapping("/employees")
    public List<Employee> addEmployee(@RequestBody List<Employee> employees){
        return employeeService.addEmployee(employees);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteById(employeeId);
        return "Employee Deleted with ID - " + employeeId;
    }
}
