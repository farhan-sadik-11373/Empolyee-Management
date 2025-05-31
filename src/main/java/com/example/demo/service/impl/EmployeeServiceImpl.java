package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeCreationDto;
import com.example.demo.exception.ValidationException;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public List<Employee> employeeList() {
        logger.info("Fetching all employees");
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        logger.info("Fetching employee with ID: {}", id);
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        logger.info("Saving employee: {}", employee.getName());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        logger.info("Deleting employee with ID: {}", id);
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Employee createEmployee(EmployeeCreationDto employeeDto) {
        logger.info("Creating new employee: {}", employeeDto.getName());

        // Validate unique NID
        if (!isNidUnique(employeeDto.getNid())) {
            logger.warn("NID already exists: {}", employeeDto.getNid());
            List<String> errors = new ArrayList<>();
            errors.add("Employee with this NID already exists");
            throw new ValidationException(errors);
        }

        // Convert DTO to entity
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setDateOfBirth(employeeDto.getDateOfBirth());
        employee.setNid(employeeDto.getNid());
        employee.setAddress(employeeDto.getAddress());
        employee.setDesignation(employeeDto.getDesignation());

        logger.info("Saving new employee to database");
        return employeeRepository.save(employee);
    }

    @Override
    public boolean isNidUnique(String nid) {
        return !employeeRepository.existsByNid(nid);
    }
}