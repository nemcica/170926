package com.algebra._6.repository;

import com.algebra._6.domain.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HardwareRepository extends JpaRepository<Hardware, String> {

    Optional<Hardware> findByCode(String code);
}

