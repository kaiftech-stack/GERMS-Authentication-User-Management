package com.germs.germs_auth.controller;

import com.germs.germs_auth.entity.Employee;
import com.germs.germs_auth.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // VIEW EMPLOYEE BY ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    // LIST ALL EMPLOYEES
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    // UPDATE EMPLOYEE
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee
    ) {
        return employeeService.updateEmployee(id, employee);
    }

    // LIST BY COMPANY
    @GetMapping("/company/{companyId}")
    public List<Employee> getByCompany(@PathVariable Long companyId) {
        return employeeService.getByCompany(companyId);
    }
}
