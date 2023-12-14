package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.ya.insurance.dto.osago.DriverNumberDto;
import ru.ya.insurance.model.osago.DriverNumberCoefficient;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DriverNumberMapper {

    List<DriverNumberDto> driverNumberListToDriverNumberDtoList(List<DriverNumberCoefficient> driverNumberCoefficientList);
}
