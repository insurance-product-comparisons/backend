package ru.ya.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.DriverNumberCoefficient;

@Repository
public interface DriverNumberCoefficientRepository extends JpaRepository<DriverNumberCoefficient, Long> {
}
