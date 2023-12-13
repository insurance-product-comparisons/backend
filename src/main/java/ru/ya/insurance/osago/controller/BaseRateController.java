package ru.ya.insurance.osago.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.osago.dto.VehicleTypeDto;
import ru.ya.insurance.osago.mapper.VehicleTypeDtoMapper;
import ru.ya.insurance.osago.model.BaseRate;
import ru.ya.insurance.osago.service.OsagoService;

import java.util.List;

@RestController
@RequestMapping("/osago/base-rate")
@RequiredArgsConstructor
@Slf4j
public class BaseRateController {
    private final OsagoService osagoService;
    private final VehicleTypeDtoMapper vehicleTypeDtoMapper;

    @GetMapping("/vehicle-types/all")
    public VehicleTypeDto getVehicleTypes() {
        log.info("Класс BaseRateController, метод getAllCategories(). Поступил GET запрос.");
        List<BaseRate> baseRates = osagoService.getVehicleTypes();

        return vehicleTypeDtoMapper.mapToVehicleTypeDto(baseRates);
    }
}
