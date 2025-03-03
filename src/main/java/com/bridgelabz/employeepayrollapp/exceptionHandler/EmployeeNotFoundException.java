package com.bridgelabz.employeepayrollapp.exceptionHandler;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}