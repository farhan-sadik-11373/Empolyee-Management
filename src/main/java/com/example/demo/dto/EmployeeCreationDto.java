package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class EmployeeCreationDto {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "NID is required")
    private String nid;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Designation is required")
    private String designation;
}