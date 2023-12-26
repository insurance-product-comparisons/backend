package ru.ya.insurance.service.osago.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.model.osago.SeasonCoefficient;
import ru.ya.insurance.repository.osago.SeasonCoefficientRepository;
import ru.ya.insurance.service.osago.SeasonCoefficientService;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class SeasonCoefficientServiceImpl implements SeasonCoefficientService {

    private final SeasonCoefficientRepository seasonCoefficientRepository;

    @Override
    public List<SeasonCoefficient> getSeasonCoefficientDtoList() {
        return seasonCoefficientRepository.findAll();
    }

}