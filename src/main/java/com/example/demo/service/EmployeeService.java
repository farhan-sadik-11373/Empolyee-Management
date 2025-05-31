package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for Employee operations
 */
public interface EmployeeService {

    /**
     * Find all employees with pagination
     */
    Page<Employee> findAllEmployees(Pageable pageable);

    /**
     * Find employee by ID
     */
    Optional<Employee> findEmployeeById(Long id);

    /**
     * Save or update an employee
     */
    Employee saveEmployee(Employee employee);

    /**
     * Delete an employee by ID
     */
    void deleteEmployee(Long id);

    /**
     * Find employee by email
     */
    Optional<Employee> findEmployeeByEmail(String email);

    /**
     * Find employees by department ID
     */
    List<Employee> findEmployeesByDepartmentId(Long departmentId);

    /**
     * Find employees by manager ID
     */
    List<Employee> findEmployeesByManagerId(Long managerId);

    /**
     * Find employees by job title
     */
    List<Employee> findEmployeesByJobTitle(String jobTitle);

    /**
     * Find employees hired after a specific date
     */
    List<Employee> findEmployeesHiredAfter(LocalDate date);

    /**
     * Search employees by name
     */
    Page<Employee> searchEmployeesByName(String searchTerm, Pageable pageable);

    /**
     * Check if email is already in use
     */
    boolean isEmailAlreadyInUse(String email, Long employeeId);
}