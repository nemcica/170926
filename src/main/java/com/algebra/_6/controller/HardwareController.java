package com.algebra._6.controller;

import com.algebra._6.dto.HardwareDto;
import com.algebra._6.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/hardware")
public class HardwareController {

    HardwareService hardwareService;

    @PostMapping
    public ResponseEntity<HardwareDto> createHardware(@RequestBody HardwareDto hardwareDto) {
        HardwareDto savedHardwareDto = hardwareService.save(hardwareDto);
        return new ResponseEntity<>(savedHardwareDto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<HardwareDto> listHardware() {
        return hardwareService.findAllHardware();
    }

    @GetMapping(path = "/{code}")
    public ResponseEntity<HardwareDto> getHardwareByCode(@PathVariable("code") String code) {
        Optional<HardwareDto> foundHardware = hardwareService.findOne(code);
        return foundHardware.map(hardwareDto -> new ResponseEntity<>(hardwareDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

