package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import ru.ya.insurance.dto.osago.DriverNumberDto;
import ru.ya.insurance.model.osago.DriverNumberCoefficient;

import java.util.List;

@Mapper
public interface DriverNumberMapper {

    List<DriverNumberDto> driverNumberListToDriverNumberDtoList(List<DriverNumberCoefficient> driverNumberCoefficientList);
}
