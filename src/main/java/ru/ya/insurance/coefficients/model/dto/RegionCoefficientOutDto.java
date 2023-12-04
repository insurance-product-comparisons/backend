package ru.ya.insurance.coefficients.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Регион содержащий в себе субъекты с Территориальным Коэффициентом
 */
@Data
@AllArgsConstructor
public class RegionCoefficientOutDto {
    private Long id;
    private String name;
    private List<SubRegionOutDto> subRegionList;
}
