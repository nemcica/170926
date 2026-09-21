package com.algebra._6.controller;

import com.algebra._6.dto.HardwareDto;
import com.algebra._6.service.HardwareService;
import jakarta.validation.Valid;
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
    public ResponseEntity<HardwareDto> createHardware(@Valid @RequestBody HardwareDto hardwareDto) {
        HardwareDto savedHardwareDto = hardwareService.save(hardwareDto);
        return new ResponseEntity<>(savedHardwareDto, HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<HardwareDto> updateHardware(@Valid @RequestBody HardwareDto hardwareDto, @PathVariable String code) {
        if (!hardwareService.exists(code)) {
            return ResponseEntity.notFound().build();
        }

        hardwareDto.setCode(code);
        HardwareDto savedHardware = hardwareService.save(hardwareDto);
        return ResponseEntity.ok(savedHardware);
    }

    @GetMapping
    public List<HardwareDto> listAllHardware() {
        return hardwareService.findAllHardware();
    }

    @GetMapping(path = "/{code}")
    public ResponseEntity<HardwareDto> getHardwareByCode(@PathVariable("code") String code) {
        Optional<HardwareDto> foundHardware = hardwareService.findOne(code);
        return foundHardware.map(hardwareDto -> new ResponseEntity<>(hardwareDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> delete(@PathVariable String code) {
        if(!hardwareService.exists(code)) {
            return ResponseEntity.notFound().build();
        }

        hardwareService.delete(code);
        return ResponseEntity.noContent().build();
    }
}

