package ru.ya.insurance.repository.kasko;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.kasko.KaskoManufactureYearCoefficient;

import java.util.Optional;

@Repository
public interface KaskoManufactureYearCoefficientRepository extends JpaRepository<KaskoManufactureYearCoefficient, Long> {

    Optional<KaskoManufactureYearCoefficient> findByManufactureYear(int manufactureYear);

}