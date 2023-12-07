package ru.ya.insurance.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.model.DriverNumberCoefficient;
import ru.ya.insurance.repository.DriverNumberCoefficientRepository;

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
