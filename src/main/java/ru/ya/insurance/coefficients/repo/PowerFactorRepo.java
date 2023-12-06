package ru.ya.insurance.coefficients.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ya.insurance.coefficients.model.PowerFactor;

public interface PowerFactorRepo extends JpaRepository<PowerFactor, Long> {
}
