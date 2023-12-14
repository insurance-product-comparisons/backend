package ru.ya.insurance.service.osago.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.model.osago.BaseRateCoefficient;
import ru.ya.insurance.repository.osago.BaseRateCoefficientRepository;
import ru.ya.insurance.service.osago.BaseRateCoefficientService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BaseRateCoefficientServiceImpl implements BaseRateCoefficientService {
    private final BaseRateCoefficientRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<BaseRateCoefficient> getBaseRateList() {
        return repository.findAll();
    }
}
