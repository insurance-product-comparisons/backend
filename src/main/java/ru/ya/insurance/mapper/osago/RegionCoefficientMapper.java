package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.ya.insurance.dto.osago.RegionCoefficientDto;
import ru.ya.insurance.model.region.RegionCoefficient;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegionCoefficientMapper {
    RegionCoefficientDto toDto(RegionCoefficient regionCoefficient);

    List<RegionCoefficientDto> toDtoList(List<RegionCoefficient> regionCoefficientList);
}
