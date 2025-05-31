package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Repository for Employee entity with custom query methods
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Find an employee by their email address
     */
    Optional<Employee> findByEmail(String email);

    /**
     * Find employees by last name
     */
    List<Employee> findByLastName(String lastName);

    /**
     * Find employees by department id
     */
    List<Employee> findByDepartmentId(Long departmentId);

    /**
     * Find employees managed by a specific manager
     */
    List<Employee> findByManagerId(Long managerId);

    /**
     * Find employees by job title
     */
    List<Employee> findByJobTitle(String jobTitle);

    /**
     * Find employees hired after a specific date
     */
    List<Employee> findByHireDateAfter(LocalDate date);

    /**
     * Find active employees
     */
    List<Employee> findByActiveTrue();

    /**
     * Find employees with salary higher than the specified amount
     */
    List<Employee> findBySalaryGreaterThan(BigDecimal salary);

    /**
     * Search employees by name (first name or last name contains the search term)
     */
    @Query("SELECT e FROM Employee e WHERE " +
            "LOWER(e.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Page<Employee> searchByName(@Param("searchTerm") String searchTerm, Pageable pageable);

    /**
     * Find employees by department and job title
     */
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName AND e.jobTitle = :jobTitle")
    List<Employee> findByDepartmentNameAndJobTitle(
            @Param("departmentName") String departmentName,
            @Param("jobTitle") String jobTitle);
}