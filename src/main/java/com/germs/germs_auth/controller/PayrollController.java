package com.germs.germs_auth.controller;

import com.germs.germs_auth.entity.PayrollSummary;
import com.germs.germs_auth.service.PayrollService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

    private final PayrollService payrollService;

    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping("/generate")
    public PayrollSummary generatePayroll(
            @RequestParam Long employeeId,
            @RequestParam String month,
            @RequestParam double baseSalary,
            @RequestParam int payableDays,
            @RequestParam double taxRate
    ) {
        return payrollService.generatePayroll(
                employeeId, month, baseSalary, payableDays, taxRate
        );
    }
}
