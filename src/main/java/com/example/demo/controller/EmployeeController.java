package com.example.demo.controller;

import com.example.demo.dto.EmployeeCreationDto;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String listEmployees(Model model) {
        logger.info("Fetching all employees");
        List<Employee> employees = employeeService.employeeList();
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @GetMapping("/{id}")
    public String getEmployee(@PathVariable Long id, Model model) {
        logger.info("Fetching employee with ID: {}", id);
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee/details";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        logger.info("Displaying employee creation form");
        model.addAttribute("employeeDto", new EmployeeCreationDto());
        return "employee/create";
    }

    @PostMapping("/create")
    public String createEmployee(@Valid @ModelAttribute("employeeDto") EmployeeCreationDto employeeDto,
                                 BindingResult result, Model model) {
        logger.info("Processing employee creation form submission");

        if (result.hasErrors()) {
            logger.warn("Validation errors in employee creation form");
            return "employee/create";
        }

        // Check for unique NID
        if (!employeeService.isNidUnique(employeeDto.getNid())) {
            logger.warn("NID already exists: {}", employeeDto.getNid());
            result.rejectValue("nid", "error.employee", "An employee with this NID already exists");
            return "employee/create";
        }

        try {
            Employee createdEmployee = employeeService.createEmployee(employeeDto);
            logger.info("Employee created successfully with ID: {}", createdEmployee.getId());
            return "redirect:/employees";
        } catch (Exception e) {
            logger.error("Error creating employee", e);
            model.addAttribute("errorMessage", "An error occurred while creating the employee");
            return "employee/create";
        }
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        logger.info("Displaying edit form for employee with ID: {}", id);
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateEmployee(@PathVariable Long id,
                                 @Valid @ModelAttribute("employee") Employee employee,
                                 BindingResult result) {
        if (result.hasErrors()) {
            logger.warn("Validation errors in employee update form");
            return "employee/edit";
        }

        logger.info("Updating employee with ID: {}", id);
        employee.setId(id);
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/delete")
    public String deleteEmployee(@PathVariable Long id) {
        logger.info("Deleting employee with ID: {}", id);
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}