package ru.ya.insurance.coefficients.service;

import ru.ya.insurance.coefficients.dto.EnginePowerDto;
import ru.ya.insurance.coefficients.model.PowerFactor;

import java.util.List;

public interface PowerFactorService {
    List<EnginePowerDto> getListEnginePowerCoefficient();
}
