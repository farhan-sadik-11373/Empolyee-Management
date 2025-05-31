package com.example.demo.service;

import com.example.demo.dto.EmployeeCreationDto;
import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> employeeList();
    Employee getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee createEmployee(EmployeeCreationDto employeeDto);
    boolean isNidUnique(String nid);
}