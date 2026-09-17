package com.algebra._6.dto;

import com.algebra._6.domain.Hardware;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HardwareDto {
    private String name;
    private String code;
    private BigDecimal price;
    private Hardware.Type type;
    private int amount;
}

