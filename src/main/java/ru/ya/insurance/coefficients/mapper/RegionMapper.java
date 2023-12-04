package ru.ya.insurance.coefficients.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.ya.insurance.coefficients.model.RegionCoefficient;
import ru.ya.insurance.coefficients.model.dto.RegionCoefficientOutDto;
import ru.ya.insurance.coefficients.model.dto.SubRegionOutDto;

import java.util.List;

/**
 * Маппер Коэффициента страховых тарифов
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegionMapper {
    RegionCoefficientOutDto toDto(RegionCoefficient regionCoefficient, List<SubRegionOutDto> subRegionList);
}
