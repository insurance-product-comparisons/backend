package ru.ya.insurance.service.osago.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.model.osago.Age;
import ru.ya.insurance.model.osago.AgeExperienceCoefficient;
import ru.ya.insurance.model.osago.AgeExperienceCoefficientId;
import ru.ya.insurance.model.osago.DrivingExperience;
import ru.ya.insurance.repository.osago.AgeExperienceCoefficientRepository;
import ru.ya.insurance.service.osago.AgeExperienceCoefficientService;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AgeExperienceCoefficientServiceImpl implements AgeExperienceCoefficientService {

    private final AgeExperienceCoefficientRepository ageExperienceCoefficientRepository;
    private final AgeServiceImpl ageServiceImpl;
    private final DrivingExperienceServiceImpl experienceService;

    @Override
    public BigDecimal getCoefficientByAgeAndExperience(Long ageId, Long experienceId) {
        Age age = ageServiceImpl.getAgeById(ageId);
        DrivingExperience experience = experienceService.getDrivingExperienceById(experienceId);

        AgeExperienceCoefficientId id = new AgeExperienceCoefficientId(age.getId(), experience.getId());
        AgeExperienceCoefficient coefficient = ageExperienceCoefficientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Коэффициент \"Возраст - Стаж\" не найден"));

        return coefficient.getCoefficient();
    }

}