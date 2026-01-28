package com.germs.germs_auth.service;

import com.germs.germs_auth.entity.PayrollSummary;
import com.germs.germs_auth.repository.PayrollSummaryRepository;
import org.springframework.stereotype.Service;

@Service
public class PayrollService {

    private final PayrollSummaryRepository payrollSummaryRepository;

    public PayrollService(PayrollSummaryRepository payrollSummaryRepository) {
        this.payrollSummaryRepository = payrollSummaryRepository;
    }

    public PayrollSummary generatePayroll(
            Long employeeId,
            String month,
            double baseSalary,
            int payableDays,
            double taxRate
    ) {
        double taxAmount = baseSalary * taxRate;
        double netSalary = baseSalary - taxAmount;

        PayrollSummary summary = new PayrollSummary();
        summary.setEmployeeId(employeeId);
        summary.setMonth(month);
        summary.setBaseSalary(baseSalary);
        summary.setPayableDays(payableDays);
        summary.setTaxAmount(taxAmount);
        summary.setNetSalary(netSalary);

        return payrollSummaryRepository.save(summary);
    }
}
