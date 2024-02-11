package ru.ya.insurance.repository.kasko;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.kasko.KaskoDrivingExperienceCoefficient;

import java.util.Optional;

@Repository
public interface KaskoDrivingExperienceCoefficientRepository extends JpaRepository<KaskoDrivingExperienceCoefficient, Long> {

    Optional<KaskoDrivingExperienceCoefficient> findByDrivingExperienceRange(String drivingExperience);

}