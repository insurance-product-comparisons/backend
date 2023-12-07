package ru.ya.insurance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.dto.DriverNumberCoefficientDto;
import ru.ya.insurance.mapper.DriverNumberMapper;
import ru.ya.insurance.service.DriverNumberCoefficientService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DriverNumberCoefficientController {

    private final DriverNumberCoefficientService service;
    private final DriverNumberMapper mapper;

    @GetMapping
    @RequestMapping("/driving-number-coefficient")
    public List<DriverNumberCoefficientDto> getAllDriverNumberCoefficientDto() {
        return service.getAllDriverNumberCoefficient().stream()
                .map(mapper::driverNumberToDriverNumberDto)
                .collect(Collectors.toList());
    }

}
