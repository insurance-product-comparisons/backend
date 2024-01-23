package ru.ya.insurance.repository.osago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.osago.BaseRateCoefficient;

import java.util.Optional;

@Repository
public interface BaseRateCoefficientRepository extends JpaRepository<BaseRateCoefficient, Long> {

    Optional<BaseRateCoefficient> findByTransportType(String transportType);

}