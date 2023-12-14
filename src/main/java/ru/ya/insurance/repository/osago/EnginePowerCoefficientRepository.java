package ru.ya.insurance.repository.osago;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ya.insurance.model.osago.EnginePowerCoefficient;

public interface EnginePowerCoefficientRepository extends JpaRepository<EnginePowerCoefficient, Integer> {
}
