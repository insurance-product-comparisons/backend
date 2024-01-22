package ru.ya.insurance.service.osago.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.exception.NotFoundException;
import ru.ya.insurance.model.osago.AgeDrivingExperienceCoefficient;
import ru.ya.insurance.repository.osago.AgeDrivingExperienceCoefficientRepository;
import ru.ya.insurance.service.osago.AgeDrivingExperienceCoefficientService;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgeDrivingExperienceCoefficientServiceImpl implements AgeDrivingExperienceCoefficientService {

    private final AgeDrivingExperienceCoefficientRepository ageDrivingExperienceCoefficientRepository;

    @Override
    public BigDecimal getCoefficientByAgeAndExperience(String ageRange, String experienceRange) {
        AgeDrivingExperienceCoefficient ageDrivingExperienceCoefficient = ageDrivingExperienceCoefficientRepository
                .findByAgeRangeAndDrivingExperienceRange(ageRange, experienceRange)
                .orElseThrow(() -> new NotFoundException("Коэффициент возраст: " + ageRange + ", стаж: " + experienceRange + " не найден"));

        if (ageDrivingExperienceCoefficient.getCoefficient() == null) {
            throw new NotFoundException("Коэффициент возраст: " + ageRange + ", стаж: " + experienceRange + " не найден");
        }

        return ageDrivingExperienceCoefficient.getCoefficient();
    }


    @Override
    public List<AgeDrivingExperienceCoefficient> getAgeDrivingExperienceCoefficientList() {
        return ageDrivingExperienceCoefficientRepository.findAll();
    }
}