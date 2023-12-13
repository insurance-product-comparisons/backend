package ru.ya.insurance.osago.dto;

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
    private List<VehicleType> vehicleTypes;
}
