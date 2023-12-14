package ru.ya.insurance.dto.osago;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class SubRegionDto {
    private Long id;
    private String name;
    private BigDecimal coefficientExclude;
    private BigDecimal coefficientInclude;
}
