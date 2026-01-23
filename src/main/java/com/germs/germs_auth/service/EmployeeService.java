package com.germs.germs_auth.service;

import com.germs.germs_auth.entity.Employee;
import com.germs.germs_auth.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // CREATE (Onboarding - Day 12)
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    // UPDATE (Day 15)
    public Employee updateEmployee(Long id, Employee updatedEmployee) {

        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // ✅ SAFE FIELDS TO UPDATE
        existing.setName(updatedEmployee.getName());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setCountry(updatedEmployee.getCountry());

        return employeeRepository.save(existing);
    }

    // VIEW BY ID
    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // LIST ALL
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    // LIST BY COMPANY
    public List<Employee> getByCompany(Long companyId) {
        return employeeRepository.findByCompanyId(companyId);
    }
}
