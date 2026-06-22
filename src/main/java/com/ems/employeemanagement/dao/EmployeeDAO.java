package com.ems.employeemanagement.dao;

import com.ems.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();
    Employee findEmployeeById(int id);
    Employee addOrUpdateEmployee(Employee employee);
    void deleteById(Employee employee);
}
