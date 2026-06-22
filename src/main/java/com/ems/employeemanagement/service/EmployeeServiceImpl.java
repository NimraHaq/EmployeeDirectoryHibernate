package com.ems.employeemanagement.service;

import com.ems.employeemanagement.customexception.EmployeeNotFoundException;
import com.ems.employeemanagement.dao.EmployeeDAO;
import com.ems.employeemanagement.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        if(Objects.isNull(employees) || employees.isEmpty()){
            throw new EmployeeNotFoundException("No Employee Found.");
        }
        return employees;
    }

    @Override
    public Employee findEmployeeById(int id) {
        Employee employee = employeeDAO.findEmployeeById(id);
        if(Objects.isNull(employee)){
            throw new EmployeeNotFoundException("Employee not found. ID - " + id);
        }
        return employee;
    }

    @Transactional //now transactions on service level
    @Override
    public List<Employee> addEmployee(List<Employee> employees) {
        List<Employee> addedEmployees = new ArrayList<>();
        for(Employee employee : employees){
            employee.setId(0);//id 0, entity manager function will insert, else update
            addedEmployees.add(employeeDAO.addOrUpdateEmployee(employee));
        }
        return addedEmployees;
    }
    @Transactional
    @Override
    public Employee updateEmployee(Employee employee) {
        try {
            return employeeDAO.addOrUpdateEmployee(employee);
        }catch(Exception e){
            throw new EmployeeNotFoundException("Employee not found.");
        }
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Employee employee = employeeDAO.findEmployeeById(id);
        if(Objects.isNull(employee)){
            throw new EmployeeNotFoundException("Employee not found. ID - " + id);
        }
        employeeDAO.deleteById(employee);
    }
}
