package ru.ya.insurance.coefficients.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.ya.insurance.coefficients.dto.SubRegionOutDto;
import ru.ya.insurance.coefficients.model.RegionCoefficient;

import java.util.List;

/**
 * Маппер Субъектов с Территориальным Коэффициентом
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubRegionMapper {
    SubRegionOutDto toDto(RegionCoefficient regionCoefficient);

    List<SubRegionOutDto> toListDto(List<RegionCoefficient> regionCoefficient);
}
