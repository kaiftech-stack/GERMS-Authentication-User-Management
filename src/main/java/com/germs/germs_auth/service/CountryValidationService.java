package com.germs.germs_auth.service;

import com.germs.germs_auth.entity.Country;
import com.germs.germs_auth.exception.CountryRuleViolationException;
import org.springframework.stereotype.Service;

@Service
public class CountryValidationService {

    public void validate(Country country, double salary, int workingHours) {

        if (country.getMinimumSalary() > 0 && salary < country.getMinimumSalary()) {
            throw new CountryRuleViolationException(
                    "Salary is below the minimum allowed for " + country.getName());
        }

        if (country.getMaxWorkingHoursPerDay() > 0 && workingHours > country.getMaxWorkingHoursPerDay()) {
            throw new CountryRuleViolationException(
                    "Working hours exceed the maximum allowed for " + country.getName());
        }
    }
}