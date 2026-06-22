package com.ems.employeemanagement.dao;

import com.ems.employeemanagement.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    EntityManager entityManager;

    //dependency/contsructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findEmployeeById(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee addOrUpdateEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(Employee employee ) {
        entityManager.remove(employee);
    }


}
