package com.ems.employeemanagement.service;

import com.ems.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeService {


    List<Employee> getAllEmployees();
    Employee findEmployeeById(int id);
    List<Employee> addEmployee(List<Employee> employees);
    Employee updateEmployee(Employee employee);
    void deleteById(int id);

}
