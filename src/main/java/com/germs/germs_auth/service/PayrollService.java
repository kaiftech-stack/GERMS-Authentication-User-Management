package com.germs.germs_auth.service;

import com.germs.germs_auth.entity.*;
import com.germs.germs_auth.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PayrollService {

    private final PayrollRepository payrollRepository;
    private final EmployeeRepository employeeRepository;

    public PayrollService(PayrollRepository payrollRepository,
                          EmployeeRepository employeeRepository) {
        this.payrollRepository = payrollRepository;
        this.employeeRepository = employeeRepository;
    }

    // ✅ Country-based payroll calculation
    public Payroll generatePayroll(Long employeeId, double basicSalary) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Country country = employee.getCountry();

        double tax = (basicSalary * country.getTaxPercentage()) / 100;
        double netSalary = basicSalary - tax;

        Payroll payroll = new Payroll();
        payroll.setEmployee(employee);
        payroll.setBasicSalary(basicSalary);
        payroll.setTaxAmount(tax);
        payroll.setNetSalary(netSalary);
        payroll.setPayrollDate(LocalDate.now());

        return payrollRepository.save(payroll);
    }
}
