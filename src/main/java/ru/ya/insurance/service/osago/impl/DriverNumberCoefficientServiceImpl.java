package ru.ya.insurance.service.osago.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.model.osago.DriverNumberCoefficient;
import ru.ya.insurance.repository.osago.DriverNumberCoefficientRepository;
import ru.ya.insurance.service.osago.DriverNumberCoefficientService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverNumberCoefficientServiceImpl implements DriverNumberCoefficientService {

    private final DriverNumberCoefficientRepository coefficientRepository;

    @Override
    public List<DriverNumberCoefficient> getAllDriverNumberCoefficient() {
        return coefficientRepository.findAll();
    }

}
