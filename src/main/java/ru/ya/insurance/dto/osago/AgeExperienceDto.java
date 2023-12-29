package ru.ya.insurance.dto.osago;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class AgeExperienceDto {
    private BigDecimal coefficient;
}