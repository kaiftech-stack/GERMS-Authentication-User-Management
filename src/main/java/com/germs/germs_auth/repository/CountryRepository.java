package com.germs.germs_auth.repository;

import com.germs.germs_auth.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
