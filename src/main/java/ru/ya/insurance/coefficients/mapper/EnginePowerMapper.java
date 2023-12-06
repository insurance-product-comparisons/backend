package ru.ya.insurance.coefficients.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.ya.insurance.coefficients.dto.EnginePowerDto;
import ru.ya.insurance.coefficients.model.EnginePower;

@Mapper(componentModel = "spring")
public interface EnginePowerMapper {

    @Mapping(target = "name", source = "power")
    EnginePowerDto powerFactorToEnginePowerDto(EnginePower enginePower);
}
