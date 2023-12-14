package ru.ya.insurance.service.osago;

import java.math.BigDecimal;

public interface AgeExperienceCoefficientService {
    BigDecimal getCoefficientByAgeAndExperience(Long ageId, Long experienceId);
}
