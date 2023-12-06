package ru.ya.insurance.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.coefficients.dto.EnginePowerDto;
import ru.ya.insurance.coefficients.service.PowerFactorService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class PowerFactorController {
    private final PowerFactorService powerFactorService;

    @GetMapping(value = "/power-factor")
    public List<EnginePowerDto> getListWithPowerFactor() {
        return powerFactorService.getListEnginePowerCoefficient();
    }
}
