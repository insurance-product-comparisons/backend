package ru.ya.insurance.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.coefficients.dto.EnginePowerDto;
import ru.ya.insurance.coefficients.service.EnginePowerService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class EnginePowerController {
    private final EnginePowerService enginePowerService;

    @GetMapping(value = "/engine-power/all")
    public List<EnginePowerDto> getListEnginePowerDto() {
        log.info("Запуск метода GET//engine-power");
        return enginePowerService.getListEnginePowerDto();
    }
}
