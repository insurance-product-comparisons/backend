package ru.ya.insurance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.ya.insurance.dto.DriverNumberCoefficientDto;
import ru.ya.insurance.model.DriverNumberCoefficient;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DriverNumberMapper {

    DriverNumberCoefficientDto driverNumberToDriverNumberDto(DriverNumberCoefficient driverNumberCoefficient);
}
