package com.germs.germs_auth.controller;

import com.germs.germs_auth.entity.Attendance;
import com.germs.germs_auth.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/check-in/{employeeId}")
    public Attendance checkIn(@PathVariable Long employeeId) {
        return attendanceService.checkIn(employeeId);
    }

    @PostMapping("/check-out/{employeeId}")
    public Attendance checkOut(@PathVariable Long employeeId) {
        return attendanceService.checkOut(employeeId);
    }

    @GetMapping("/{employeeId}")
    public List<Attendance> getAttendance(@PathVariable Long employeeId) {
        return attendanceService.getAttendance(employeeId);
    }
}
