package com.algebra._6.dto;

import com.algebra._6.domain.Hardware;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HardwareDto {

    private Long id;

    @NotBlank(message = "Name is required.")
    private String name;

    @NotBlank(message = "Code is required.")
    private String code;

    @Positive
    private BigDecimal price;

    @NotNull(message = "Type is required.")
    private Hardware.Type type;

    @PositiveOrZero
    private Integer amount;
}

