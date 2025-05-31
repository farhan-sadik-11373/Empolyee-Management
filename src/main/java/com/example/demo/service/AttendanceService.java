package com.example.demo.service;

import com.example.demo.model.Attendance;

import java.util.List;

public interface AttendanceService {
    void markAttendance(Attendance attendance);
    List<Attendance> getAttendanceRecords(Long employeeId, String monthYear);
    List<Attendance> getAttendanceHistory(Long employeeId);
    void modifyAttendance(Long attendanceId, Attendance updatedAttendance);
}