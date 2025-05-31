package com.example.demo.repository;

import com.example.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Department entity with custom query methods
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /**
     * Find a department by its name
     */
    Optional<Department> findByName(String name);

    /**
     * Find active departments
     */
    List<Department> findByActiveTrue();

    /**
     * Find departments that have employees
     */
    @Query("SELECT DISTINCT d FROM Department d JOIN d.employees e WHERE d.active = true")
    List<Department> findDepartmentsWithEmployees();

    /**
     * Find departments by manager id
     */
    List<Department> findByManagerId(Long managerId);
}
