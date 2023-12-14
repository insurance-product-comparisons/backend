package ru.ya.insurance.service.osago.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.model.osago.EnginePowerCoefficient;
import ru.ya.insurance.repository.osago.EnginePowerCoefficientRepository;
import ru.ya.insurance.service.osago.EnginePowerCoefficientService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnginePowerCoefficientServiceImpl implements EnginePowerCoefficientService {
    private final EnginePowerCoefficientRepository enginePowerCoefficientRepository;

    @Override
    public List<EnginePowerCoefficient> getEnginePowerList() {
        return enginePowerCoefficientRepository.findAll();
    }
}
