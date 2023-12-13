package ru.ya.insurance.ageExperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.ageExperience.model.AgeExperienceCoefficient;
import ru.ya.insurance.ageExperience.model.AgeExperienceCoefficientId;

@Repository
public interface AgeExperienceCoefficientRepository extends JpaRepository<AgeExperienceCoefficient, AgeExperienceCoefficientId> {

}