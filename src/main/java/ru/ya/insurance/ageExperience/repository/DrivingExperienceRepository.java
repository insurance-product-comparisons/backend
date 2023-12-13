package ru.ya.insurance.ageExperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.ageExperience.model.DrivingExperience;

@Repository
public interface DrivingExperienceRepository extends JpaRepository<DrivingExperience, Long> {

}