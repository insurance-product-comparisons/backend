package ru.ya.insurance.ageExperience.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.ageExperience.model.Age;
import ru.ya.insurance.ageExperience.model.AgeExperienceCoefficient;
import ru.ya.insurance.ageExperience.model.AgeExperienceCoefficientId;
import ru.ya.insurance.ageExperience.model.DrivingExperience;
import ru.ya.insurance.ageExperience.repository.AgeExperienceCoefficientRepository;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class AgeExperienceCoefficientService {

    private final AgeExperienceCoefficientRepository ageExperienceCoefficientRepository;
    private final AgeService ageService;
    private final DrivingExperienceService experienceService;

    public BigDecimal getCoefficientByAgeAndExperience(Long ageId, Long experienceId) {
        Age age = ageService.getAgeById(ageId);
        DrivingExperience experience = experienceService.getDrivingExperienceById(experienceId);

        AgeExperienceCoefficientId id = new AgeExperienceCoefficientId(age.getId(), experience.getId());
        AgeExperienceCoefficient coefficient = ageExperienceCoefficientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Коэффициент \"Возраст - Стаж\" не найден"));

        return coefficient.getCoefficient();
    }

}