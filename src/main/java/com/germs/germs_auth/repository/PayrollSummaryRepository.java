package com.germs.germs_auth.repository;

import com.germs.germs_auth.entity.PayrollSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollSummaryRepository extends JpaRepository<PayrollSummary, Long> {
}
