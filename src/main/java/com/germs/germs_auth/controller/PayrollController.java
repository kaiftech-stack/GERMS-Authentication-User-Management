package com.germs.germs_auth.controller;

import com.germs.germs_auth.entity.Payroll;
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
    public Payroll generatePayroll(
            @RequestParam Long employeeId,
            @RequestParam double basicSalary) {

        return payrollService.generatePayroll(employeeId, basicSalary);
    }
}
