package ru.ya.insurance.coefficients.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Субъект с Территориальным Коэффициентом
 */
@Getter
@Setter
@AllArgsConstructor
public class SubRegionOutDto {
    private Long id;
    private String name;
    private BigDecimal coefficientExclude;
    private BigDecimal coefficientInclude;
}
