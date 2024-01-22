package ru.ya.insurance.dto.osago;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgeDrivingExperienceCoefficientDto {

    private Long id;
    private String ageRange;
    private String drivingExperienceRange;
    private BigDecimal coefficient;

}