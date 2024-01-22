package ru.ya.insurance.service.osago;

import ru.ya.insurance.model.osago.AgeDrivingExperienceCoefficient;

import java.math.BigDecimal;
import java.util.List;

public interface AgeDrivingExperienceCoefficientService {

    BigDecimal getCoefficientByAgeAndExperience(String ageRange, String experienceRange);

    List<AgeDrivingExperienceCoefficient> getAgeDrivingExperienceCoefficientList();

}