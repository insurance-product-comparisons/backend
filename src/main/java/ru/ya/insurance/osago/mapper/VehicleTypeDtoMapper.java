package ru.ya.insurance.osago.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.ya.insurance.osago.dto.VehicleType;
import ru.ya.insurance.osago.dto.VehicleTypeDto;
import ru.ya.insurance.osago.model.BaseRate;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehicleTypeDtoMapper {
    VehicleType mapToVehicleType(BaseRate baseRate);

    default VehicleTypeDto mapToVehicleTypeDto(List<BaseRate> baseRates) {
        VehicleTypeDto vehicleTypeDto = new VehicleTypeDto();

        vehicleTypeDto.setVehicleTypes(baseRates.stream()
                .map(this::mapToVehicleType)
                .collect(Collectors.toList()));

        return vehicleTypeDto;
    }
}
