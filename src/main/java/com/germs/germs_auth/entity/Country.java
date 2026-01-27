package com.germs.germs_auth.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String currency;
    private String timeZone;

    // ✅ Tax percentage (example: 10 = 10%)
    private double taxPercentage;

    // Getters & Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCurrency() { return currency; }
    public String getTimeZone() { return timeZone; }
    public double getTaxPercentage() { return taxPercentage; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setTimeZone(String timeZone) { this.timeZone = timeZone; }
    public void setTaxPercentage(double taxPercentage) { this.taxPercentage = taxPercentage; }
}
