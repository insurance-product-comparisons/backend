package ru.ya.insurance.coefficients.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.coefficients.dto.EnginePowerDto;
import ru.ya.insurance.coefficients.mapper.EnginePowerMapper;
import ru.ya.insurance.coefficients.repo.EnginePowerRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EnginePowerServiceImpl implements EnginePowerService {
    private final EnginePowerRepo enginePowerRepo;
    private final EnginePowerMapper enginePowerMapper;

    @Override
    public List<EnginePowerDto> getListEnginePowerDto() {
        return enginePowerRepo.findAll().stream()
            .map(enginePowerMapper::powerFactorToEnginePowerDto)
            .collect(Collectors.toList());
    }
}
