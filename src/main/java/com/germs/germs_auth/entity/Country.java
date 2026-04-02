package com.germs.germs_auth.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String currency;
    private String timeZone;
    private int maxWorkingHoursPerDay;
    private double minimumSalary;
    private double taxPercentage;
    private int annualLeaveLimit;

    public Country() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getTimeZone() { return timeZone; }
    public void setTimeZone(String timeZone) { this.timeZone = timeZone; }

    public int getMaxWorkingHoursPerDay() { return maxWorkingHoursPerDay; }
    public void setMaxWorkingHoursPerDay(int maxWorkingHoursPerDay) { this.maxWorkingHoursPerDay = maxWorkingHoursPerDay; }

    public double getMinimumSalary() { return minimumSalary; }
    public void setMinimumSalary(double minimumSalary) { this.minimumSalary = minimumSalary; }

    public double getTaxPercentage() { return taxPercentage; }
    public void setTaxPercentage(double taxPercentage) { this.taxPercentage = taxPercentage; }

    public int getAnnualLeaveLimit() { return annualLeaveLimit; }
    public void setAnnualLeaveLimit(int annualLeaveLimit) { this.annualLeaveLimit = annualLeaveLimit; }
}