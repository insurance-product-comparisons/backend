package ru.ya.insurance.repository.osago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.osago.EnginePowerCoefficient;

import java.util.Optional;

@Repository
public interface EnginePowerCoefficientRepository extends JpaRepository<EnginePowerCoefficient, Integer> {

    Optional<EnginePowerCoefficient> findByPower(String enginePower);

}