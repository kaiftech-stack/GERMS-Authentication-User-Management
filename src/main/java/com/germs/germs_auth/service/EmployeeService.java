package com.germs.germs_auth.service;

import com.germs.germs_auth.entity.Company;
import com.germs.germs_auth.entity.Country;
import com.germs.germs_auth.entity.Employee;
import com.germs.germs_auth.repository.CompanyRepository;
import com.germs.germs_auth.repository.CountryRepository;
import com.germs.germs_auth.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final CountryRepository countryRepository;
    private final CountryValidationService countryValidationService;

    public EmployeeService(EmployeeRepository employeeRepository,
                           CompanyRepository companyRepository,
                           CountryRepository countryRepository,
                           CountryValidationService countryValidationService) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.countryRepository = countryRepository;
        this.countryValidationService = countryValidationService;
    }

    public Employee onboardEmployee(String firstName,
                                    String lastName,
                                    String email,
                                    Integer workingHours,
                                    Double salary,
                                    Long companyId,
                                    Long countryId) {

        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        Country country = countryRepository.findById(countryId)
                .orElseThrow(() -> new RuntimeException("Country not found"));

        // ✅ Country-based validation
        countryValidationService.validateEmployeeAgainstCountryRules(
                country, workingHours, salary
        );

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setWorkingHoursPerDay(workingHours);
        employee.setSalary(salary);
        employee.setCompany(company);
        employee.setCountry(country);

        return employeeRepository.save(employee);
    }
}
