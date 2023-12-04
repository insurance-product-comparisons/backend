package ru.ya.insurance.coefficients.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Субъект с Территориальным Коэффициентом
 */
@Data
@AllArgsConstructor
public class SubRegionOutDto {
    private Long id;
    private String name;
    private BigDecimal coefficientExclude;
    private BigDecimal coefficientInclude;
}
