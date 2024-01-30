package ru.ya.insurance.mapper.osago;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.ya.insurance.dto.osago.RegionDto;
import ru.ya.insurance.model.region.Region;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        uses = RegionCoefficientMapper.class)
public interface RegionMapper {
    RegionDto toDto(Region region);

    List<RegionDto> toDtoList(List<Region> regionList);
}
