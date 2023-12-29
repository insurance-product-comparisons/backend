package ru.ya.insurance.dto.osago;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RegionDto {
    private Long id;
    private String name;
    private List<RegionCoefficientDto> regionCoefficientList;
}
