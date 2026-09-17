package com.algebra._6.mapper;

import com.algebra._6.domain.Hardware;
import com.algebra._6.dto.HardwareDto;
import org.springframework.stereotype.Component;

@Component
public class HardwareMapper {

    public HardwareDto toDto(Hardware hardware) {
        if(hardware == null) return null;

        HardwareDto hardwareDto = new HardwareDto();
        hardwareDto.setName(hardware.getName());
        hardwareDto.setCode(hardware.getCode());
        hardwareDto.setPrice(hardware.getPrice());
        hardwareDto.setType(hardware.getType());
        hardwareDto.setAmount(hardware.getAmount());
        return hardwareDto;
    }

    public Hardware toEntity(HardwareDto hardwareDto) {
        if(hardwareDto == null) return  null;

        Hardware hardware = new Hardware();
        hardware.setName(hardwareDto.getName());
        hardware.setCode(hardwareDto.getCode());
        hardware.setPrice(hardwareDto.getPrice());
        hardware.setType(hardwareDto.getType());
        hardware.setAmount(hardwareDto.getAmount());
        return hardware;
    }

}
