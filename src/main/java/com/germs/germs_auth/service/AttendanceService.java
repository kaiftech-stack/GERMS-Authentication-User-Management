package com.germs.germs_auth.service;

import com.germs.germs_auth.entity.Attendance;
import com.germs.germs_auth.entity.Employee;
import com.germs.germs_auth.repository.AttendanceRepository;
import com.germs.germs_auth.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    public AttendanceService(AttendanceRepository attendanceRepository,
                             EmployeeRepository employeeRepository) {
        this.attendanceRepository = attendanceRepository;
        this.employeeRepository = employeeRepository;
    }

    // ✅ Check-in with country time zone
    public Attendance checkIn(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        ZoneId zoneId = ZoneId.of(employee.getCountry().getTimeZone());

        LocalDate today = LocalDate.now(zoneId);
        LocalDateTime now = LocalDateTime.now(zoneId);

        if (attendanceRepository.findByEmployeeAndDate(employee, today).isPresent()) {
            throw new RuntimeException("Already checked in today");
        }

        Attendance attendance = new Attendance();
        attendance.setEmployee(employee);
        attendance.setDate(today);
        attendance.setCheckInTime(now);

        return attendanceRepository.save(attendance);
    }

    // ✅ Check-out
    public Attendance checkOut(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        ZoneId zoneId = ZoneId.of(employee.getCountry().getTimeZone());
        LocalDate today = LocalDate.now(zoneId);

        Attendance attendance = attendanceRepository
                .findByEmployeeAndDate(employee, today)
                .orElseThrow(() -> new RuntimeException("Check-in not found"));

        attendance.setCheckOutTime(LocalDateTime.now(zoneId));
        return attendanceRepository.save(attendance);
    }

    // View attendance
    public List<Attendance> getAttendance(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return attendanceRepository.findByEmployee(employee);
    }
}
