package ru.ya.insurance.dto.osago;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleTypeDto {
    private List<BaseRateDto> vehicleTypes;
    private Integer id;
    private String transportType;
}
