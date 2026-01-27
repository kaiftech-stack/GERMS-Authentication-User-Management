package com.germs.germs_auth.repository;

import com.germs.germs_auth.entity.Attendance;
import com.germs.germs_auth.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findByEmployeeAndDate(Employee employee, LocalDate date);

    List<Attendance> findByEmployee(Employee employee);
}
