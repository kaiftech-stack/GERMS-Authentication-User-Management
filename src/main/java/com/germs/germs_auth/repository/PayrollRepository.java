package com.germs.germs_auth.repository;

import com.germs.germs_auth.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
}
