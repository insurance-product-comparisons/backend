package ru.ya.insurance.coefficients.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ya.insurance.coefficients.model.EnginePower;

public interface EnginePowerRepo extends JpaRepository<EnginePower, Integer> {
}
