package com.example.demo.service;

import com.example.demo.model.Attendance;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.exception.AttendanceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    private static final Logger logger = LoggerFactory.getLogger(AttendanceServiceImpl.class);

    @Override
    public void markAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
        logger.info("Attendance marked for employee ID: {}", attendance.getEmployeeId());
    }

    @Override
    public List<Attendance> getAttendanceRecords(Long employeeId) {
        if (employeeId != null) {
            return attendanceRepository.findByEmployeeId(employeeId);
        }
        return attendanceRepository.findAll();
    }

    @Override
    public void modifyAttendance(Long attendanceId, Attendance updatedAttendance) {
        Attendance existingAttendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new AttendanceNotFoundException(attendanceId));
        existingAttendance.setDate(updatedAttendance.getDate());
        existingAttendance.setCheckinTime(updatedAttendance.getCheckinTime());
        existingAttendance.setCheckoutTime(updatedAttendance.getCheckoutTime());
        attendanceRepository.save(existingAttendance);
        logger.info("Attendance record updated for ID: {}", attendanceId);
    }
}