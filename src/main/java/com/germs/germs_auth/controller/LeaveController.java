package com.germs.germs_auth.controller;

import com.germs.germs_auth.entity.LeaveRequest;
import com.germs.germs_auth.entity.LeaveStatus;
import com.germs.germs_auth.service.LeaveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    private final LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    // Apply leave
    @PostMapping("/apply/{employeeId}")
    public LeaveRequest applyLeave(@PathVariable Long employeeId,
                                   @RequestBody LeaveRequest request) {
        return leaveService.applyLeave(employeeId, request);
    }

    // Approve / Reject leave
    @PutMapping("/status/{leaveId}")
    public LeaveRequest updateStatus(@PathVariable Long leaveId,
                                     @RequestParam LeaveStatus status) {
        return leaveService.updateStatus(leaveId, status);
    }

    // View leaves
    @GetMapping("/{employeeId}")
    public List<LeaveRequest> getLeaves(@PathVariable Long employeeId) {
        return leaveService.getEmployeeLeaves(employeeId);
    }
}
