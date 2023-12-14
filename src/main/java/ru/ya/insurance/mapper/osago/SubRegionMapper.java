package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.ya.insurance.dto.osago.SubRegionDto;
import ru.ya.insurance.model.osago.RegionCoefficient;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubRegionMapper {
    SubRegionDto regionCoefficientToSubRegionDto(RegionCoefficient regionCoefficient);

    List<SubRegionDto> regionCoefficientListToSubregionDtoList(List<RegionCoefficient> regionCoefficient);
}
