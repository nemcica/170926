package com.algebra._6.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hardware {

    private Long id;
    private String name;
    private String code;
    private BigDecimal price;
    private Type type;
    private int amount;

    public enum Type {
        GPU,
        CPU,
        MBO,
        RAM,
        STORAGE,
        OTHER
    }
}




