package com.example.demo.controller;

import com.example.demo.model.Attendance;
import com.example.demo.service.AttendanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    @GetMapping("/create")
    public String showAttendanceForm(Model model) {
        model.addAttribute("attendance", new Attendance());
        return "attendance-form";
    }

    @PostMapping("/create")
    public String markAttendance(@ModelAttribute @Valid Attendance attendance, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Validation errors occurred.");
            return "attendance-form";
        }
        attendanceService.markAttendance(attendance);
        logger.info("Attendance marked for employee ID: {}", attendance.getEmployeeId());
        return "redirect:/attendances/list";
    }

    @GetMapping("/list")
    public String listAttendances(@RequestParam(required = false) Long employeeId, Model model) {
        List<Attendance> attendances = attendanceService.getAttendanceHistory(employeeId);
        if (attendances.isEmpty()) {
            model.addAttribute("errorMessage", "No attendance records found for the given criteria.");
        }
        model.addAttribute("attendances", attendances);
        return "attendance-list";
    }
}