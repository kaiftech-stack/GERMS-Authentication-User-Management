package com.germs.germs_auth.service;

import com.germs.germs_auth.entity.Employee;
import com.germs.germs_auth.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Placeholder method (logic will be added on Day 12)
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
