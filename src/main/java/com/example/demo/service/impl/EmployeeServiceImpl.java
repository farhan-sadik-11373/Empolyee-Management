package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the EmployeeService interface
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Employee> findAllEmployees(Pageable pageable) {
        logger.debug("Finding all employees with pagination");
        return employeeRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> findEmployeeById(Long id) {
        logger.debug("Finding employee with id: {}", id);
        return employeeRepository.findById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        logger.debug("Saving employee: {}", employee.getEmail());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        logger.debug("Deleting employee with id: {}", id);
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> findEmployeeByEmail(String email) {
        logger.debug("Finding employee with email: {}", email);
        return employeeRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findEmployeesByDepartmentId(Long departmentId) {
        logger.debug("Finding employees by department id: {}", departmentId);
        return employeeRepository.findByDepartmentId(departmentId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findEmployeesByManagerId(Long managerId) {
        logger.debug("Finding employees by manager id: {}", managerId);
        return employeeRepository.findByManagerId(managerId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findEmployeesByJobTitle(String jobTitle) {
        logger.debug("Finding employees by job title: {}", jobTitle);
        return employeeRepository.findByJobTitle(jobTitle);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findEmployeesHiredAfter(LocalDate date) {
        logger.debug("Finding employees hired after: {}", date);
        return employeeRepository.findByHireDateAfter(date);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Employee> searchEmployeesByName(String searchTerm, Pageable pageable) {
        logger.debug("Searching employees by name containing: {}", searchTerm);
        return employeeRepository.searchByName(searchTerm, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isEmailAlreadyInUse(String email, Long employeeId) {
        logger.debug("Checking if email is already in use: {}", email);
        Optional<Employee> existingEmployee = employeeRepository.findByEmail(email);
        return existingEmployee.isPresent() &&
                !existingEmployee.get().getId().equals(employeeId);
    }
}
