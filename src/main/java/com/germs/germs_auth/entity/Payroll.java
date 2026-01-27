package com.germs.germs_auth.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payrolls")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;

    private double basicSalary;
    private double taxAmount;
    private double netSalary;

    private LocalDate payrollDate;

    // Getters & Setters
    public Long getId() { return id; }
    public Employee getEmployee() { return employee; }
    public double getBasicSalary() { return basicSalary; }
    public double getTaxAmount() { return taxAmount; }
    public double getNetSalary() { return netSalary; }
    public LocalDate getPayrollDate() { return payrollDate; }

    public void setId(Long id) { this.id = id; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }
    public void setTaxAmount(double taxAmount) { this.taxAmount = taxAmount; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }
    public void setPayrollDate(LocalDate payrollDate) { this.payrollDate = payrollDate; }
}
