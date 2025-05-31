package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long employeeId;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime checkinTime;

    @NotNull
    private LocalTime checkoutTime;
}