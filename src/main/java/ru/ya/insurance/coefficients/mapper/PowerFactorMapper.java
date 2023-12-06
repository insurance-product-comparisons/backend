package ru.ya.insurance.coefficients.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.ya.insurance.coefficients.dto.EnginePowerDto;
import ru.ya.insurance.coefficients.model.PowerFactor;

@Mapper(componentModel = "spring")
public interface PowerFactorMapper {

    @Mapping(target = "name", source = "power")
    EnginePowerDto makeEnginePowerDto(PowerFactor powerFactor);
}
