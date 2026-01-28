package com.germs.germs_auth.service;

import com.germs.germs_auth.entity.*;
import com.germs.germs_auth.repository.EmployeeRepository;
import com.germs.germs_auth.repository.LeaveRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;
    private final EmployeeRepository employeeRepository;

    public LeaveService(LeaveRepository leaveRepository,
                        EmployeeRepository employeeRepository) {
        this.leaveRepository = leaveRepository;
        this.employeeRepository = employeeRepository;
    }

    // Apply for leave
    public LeaveRequest applyLeave(Long employeeId,
                                   LeaveRequest request) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        long days = ChronoUnit.DAYS.between(
                request.getStartDate(), request.getEndDate()) + 1;

        int allowedLeaves = employee.getCountry().getAnnualLeaveLimit();

        if (days > allowedLeaves) {
            throw new RuntimeException("Leave exceeds country policy");
        }

        request.setEmployee(employee);
        request.setStatus(LeaveStatus.PENDING);

        return leaveRepository.save(request);
    }

    // Approve or reject leave
    public LeaveRequest updateStatus(Long leaveId, LeaveStatus status) {

        LeaveRequest leave = leaveRepository.findById(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));

        leave.setStatus(status);
        return leaveRepository.save(leave);
    }

    // View employee leaves
    public List<LeaveRequest> getEmployeeLeaves(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return leaveRepository.findByEmployee(employee);
    }
}
