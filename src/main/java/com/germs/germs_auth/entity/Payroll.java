package com.germs.germs_auth.entity;

import jakarta.persistence.*;
import java.time.YearMonth;

@Entity
@Table(name = "payrolls")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    private Double basicSalary;
    private Double allowances;
    private Double deductions;
    private Double netSalary;

    private String country;

    private YearMonth payrollMonth;

    // Constructors
    public Payroll() {}

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getAllowances() {
        return allowances;
    }

    public void setAllowances(Double allowances) {
        this.allowances = allowances;
    }

    public Double getDeductions() {
        return deductions;
    }

    public void setDeductions(Double deductions) {
        this.deductions = deductions;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public YearMonth getPayrollMonth() {
        return payrollMonth;
    }

    public void setPayrollMonth(YearMonth payrollMonth) {
        this.payrollMonth = payrollMonth;
    }
}
