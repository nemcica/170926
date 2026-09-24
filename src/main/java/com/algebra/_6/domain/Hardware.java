package com.algebra._6.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hardware {
    private String name;
    @Id
    private String code;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
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




