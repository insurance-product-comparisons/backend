package ru.ya.insurance.repository.osago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.osago.DriverNumberCoefficient;

@Repository
public interface DriverNumberCoefficientRepository extends JpaRepository<DriverNumberCoefficient, Long> {
}
