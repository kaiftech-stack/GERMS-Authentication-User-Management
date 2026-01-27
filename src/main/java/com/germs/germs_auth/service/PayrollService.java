package com.germs.germs_auth.service;

import com.germs.germs_auth.entity.Payroll;
import com.germs.germs_auth.repository.PayrollRepository;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;

@Service
public class PayrollService {

    private final PayrollRepository payrollRepository;

    public PayrollService(PayrollRepository payrollRepository) {
        this.payrollRepository = payrollRepository;
    }

    // Create Payroll (Calculation logic comes Day 17)
    public Payroll createPayroll(Long employeeId,
                                 Double basic,
                                 Double allowances,
                                 Double deductions,
                                 String country) {

        Payroll payroll = new Payroll();
        payroll.setEmployeeId(employeeId);
        payroll.setBasicSalary(basic);
        payroll.setAllowances(allowances);
        payroll.setDeductions(deductions);
        payroll.setCountry(country);

        Double netSalary = basic + allowances - deductions;
        payroll.setNetSalary(netSalary);

        payroll.setPayrollMonth(YearMonth.now());

        return payrollRepository.save(payroll);
    }

    public List<Payroll> getEmployeePayrolls(Long employeeId) {
        return payrollRepository.findByEmployeeId(employeeId);
    }
}
