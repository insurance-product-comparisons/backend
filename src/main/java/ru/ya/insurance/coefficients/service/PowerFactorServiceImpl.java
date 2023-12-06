package ru.ya.insurance.coefficients.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.coefficients.dto.EnginePowerDto;
import ru.ya.insurance.coefficients.mapper.PowerFactorMapper;
import ru.ya.insurance.coefficients.repo.PowerFactorRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PowerFactorServiceImpl implements PowerFactorService {
    private final PowerFactorRepo powerFactorRepo;
    private final PowerFactorMapper powerFactorMapper;

    @Override
    public List<EnginePowerDto> getListEnginePowerCoefficient() {
        return powerFactorRepo.findAll().stream()
            .map(powerFactorMapper::makeEnginePowerDto)
            .collect(Collectors.toList());
    }
}
