package ru.ya.insurance.dto.osago;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class RegionCoefficientDto {

    private Long id;
    private String region;
    private BigDecimal vehicleCoefficient;
    private BigDecimal specialVehicleCoefficient;

}