package com.algebra._6.service;


import com.algebra._6.dto.HardwareDto;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface HardwareService {
    HardwareDto save(HardwareDto hardwareDto);

    HardwareDto save(String code, HardwareDto hardwareDto);

    List<HardwareDto> findAllHardware();

    Optional<HardwareDto> findOne(String code);

    boolean exists(String code);

    void delete(String code);

}

