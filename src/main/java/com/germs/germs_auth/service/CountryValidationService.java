package com.germs.germs_auth.service;

import com.germs.germs_auth.entity.Country;
import com.germs.germs_auth.exception.CountryRuleViolationException;
import org.springframework.stereotype.Service;

@Service
public class CountryValidationService {

    public void validateEmployeeAgainstCountryRules(
            Country country,
            Integer workingHours,
            Double salary
    ) {

        if (country.getMaxWorkingHoursPerDay() != null &&
                workingHours > country.getMaxWorkingHoursPerDay()) {
            throw new CountryRuleViolationException(
                    "Working hours exceed limit for " + country.getName()
            );
        }

        if (country.getMinimumSalary() != null &&
                salary < country.getMinimumSalary()) {
            throw new CountryRuleViolationException(
                    "Salary below minimum wage for " + country.getName()
            );
        }
    }
}

