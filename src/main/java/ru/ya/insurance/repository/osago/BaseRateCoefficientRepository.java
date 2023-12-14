package ru.ya.insurance.repository.osago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.osago.BaseRateCoefficient;

@Repository
public interface BaseRateCoefficientRepository extends JpaRepository<BaseRateCoefficient, Long> {
}
