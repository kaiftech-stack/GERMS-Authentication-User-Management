package com.germs.germs_auth.controller;

import com.germs.germs_auth.entity.Payroll;
import com.germs.germs_auth.service.PayrollService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

    private final PayrollService payrollService;

    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping("/generate")
    public Payroll generatePayroll(
            @RequestParam Long employeeId,
            @RequestParam Double basic,
            @RequestParam Double allowances,
            @RequestParam Double deductions,
            @RequestParam String country
    ) {
        return payrollService.createPayroll(
                employeeId, basic, allowances, deductions, country
        );
    }

    @GetMapping("/employee/{employeeId}")
    public List<Payroll> getEmployeePayrolls(@PathVariable Long employeeId) {
        return payrollService.getEmployeePayrolls(employeeId);
    }
}
