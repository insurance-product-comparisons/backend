package ru.ya.insurance.repository.osago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.osago.AgeExperienceCoefficient;
import ru.ya.insurance.model.osago.AgeExperienceCoefficientId;

@Repository
public interface AgeExperienceCoefficientRepository extends JpaRepository<AgeExperienceCoefficient, AgeExperienceCoefficientId> {
}