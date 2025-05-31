package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AttendanceNotFoundException extends RuntimeException {
    public AttendanceNotFoundException(Long employeeId) {
        super("Employee not found with ID: " + employeeId);
    }
}