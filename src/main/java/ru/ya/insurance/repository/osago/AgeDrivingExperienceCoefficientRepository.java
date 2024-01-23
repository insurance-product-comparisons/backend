package ru.ya.insurance.repository.osago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.osago.AgeDrivingExperienceCoefficient;

import java.util.Optional;

@Repository
public interface AgeDrivingExperienceCoefficientRepository extends JpaRepository<AgeDrivingExperienceCoefficient, Long> {
    Optional<AgeDrivingExperienceCoefficient> findByAgeRangeAndDrivingExperienceRange(String ageRange, String experienceRange);
}
