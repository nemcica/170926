package com.algebra._6.service.impl;

import com.algebra._6.domain.Hardware;
import com.algebra._6.dto.HardwareDto;
import com.algebra._6.mapper.HardwareMapper;
import com.algebra._6.repository.HardwareRepository;
import com.algebra._6.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    HardwareMapper hardwareMapper;
    HardwareRepository hardwareRepository;

    @Override
    public HardwareDto save(HardwareDto hardwareDto) {
        Hardware savedHardware = hardwareMapper.toEntity(hardwareDto);
        return hardwareMapper.toDto(hardwareRepository.save(savedHardware));
    }

    @Override
    public List<HardwareDto> findAllHardware() {
        return hardwareRepository.findAll().stream()
                .map(hardwareMapper::toDto)
                .toList();
    }

    @Override
    public Optional<HardwareDto> findOne(String code) {
        Optional<Hardware> foundHardware = hardwareRepository.findByCode(code);
        return foundHardware.map(hardware -> hardwareMapper.toDto(hardware));
    }

    @Override
    public boolean exists(String code) {
        return hardwareRepository.existsById(code);
    }

    @Override
    public void delete(String code) {
        hardwareRepository.deleteById(code);
    }
}

