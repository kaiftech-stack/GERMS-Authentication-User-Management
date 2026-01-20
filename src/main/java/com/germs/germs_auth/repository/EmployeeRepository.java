package com.germs.germs_auth.repository;

import com.germs.germs_auth.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
