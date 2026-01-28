package com.germs.germs_auth.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payroll_summaries")
public class PayrollSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String month;
    private double baseSalary;
    private int payableDays;
    private double taxAmount;
    private double netSalary;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public int getPayableDays() { return payableDays; }
    public void setPayableDays(int payableDays) { this.payableDays = payableDays; }

    public double getTaxAmount() { return taxAmount; }
    public void setTaxAmount(double taxAmount) { this.taxAmount = taxAmount; }

    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }
}
