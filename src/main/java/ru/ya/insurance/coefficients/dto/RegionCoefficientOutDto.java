package ru.ya.insurance.coefficients.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Регион содержащий в себе субъекты с Территориальным Коэффициентом
 */
@Getter
@Setter
@AllArgsConstructor
public class RegionCoefficientOutDto {
    private Long id;
    private String name;
    private List<SubRegionOutDto> subRegionList;
}
