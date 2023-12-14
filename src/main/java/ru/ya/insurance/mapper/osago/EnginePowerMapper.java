package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.ya.insurance.dto.osago.EnginePowerDto;
import ru.ya.insurance.model.osago.EnginePowerCoefficient;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EnginePowerMapper {

    @Mapping(target = "name", source = "power")
    EnginePowerDto enginePowerCoefficientToEnginePowerDto(EnginePowerCoefficient enginePowerCoefficient);

    List<EnginePowerDto> enginePowerCoefficientListToEnginePowerDtoList(List<EnginePowerCoefficient> enginePowerCoefficientList);
}
