package com.algebra._6.service;


import com.algebra._6.dto.HardwareDto;

import java.util.List;
import java.util.Optional;

public interface HardwareService {
    HardwareDto save(HardwareDto hardwareDto);

    List<HardwareDto> findAllHardware();

    Optional<HardwareDto> findOne(String code);

}

