package com.ems.employeemanagement.rest;

import com.ems.employeemanagement.customerrorresponse.EmployeeErrorResponse;
import com.ems.employeemanagement.customexception.EmployeeNotFoundException;
import com.ems.employeemanagement.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    //one method for one time of exception, else it will cause exception of ambigous method
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> employeeNotFoundException(EmployeeNotFoundException e){
        EmployeeErrorResponse error = new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> employeeNotFoundException(Exception e){
        EmployeeErrorResponse error = new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
