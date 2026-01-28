package com.germs.germs_auth.repository;

import com.germs.germs_auth.entity.LeaveRequest;
import com.germs.germs_auth.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<LeaveRequest, Long> {

    List<LeaveRequest> findByEmployee(Employee employee);
}

