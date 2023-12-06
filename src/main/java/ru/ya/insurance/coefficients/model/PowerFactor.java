package ru.ya.insurance.coefficients.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "engine_power", schema = "public")
public class PowerFactor {
    private String power;
    private BigDecimal coefficient;
}
