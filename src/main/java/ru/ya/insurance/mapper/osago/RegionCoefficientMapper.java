package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.ya.insurance.dto.osago.RegionCoefficientDto;
import ru.ya.insurance.model.osago.RegionCoefficient;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegionCoefficientMapper {
    RegionCoefficientDto toDto(RegionCoefficient regionCoefficient);

    List<RegionCoefficientDto> toDtoList(List<RegionCoefficient> regionCoefficientList);
}
