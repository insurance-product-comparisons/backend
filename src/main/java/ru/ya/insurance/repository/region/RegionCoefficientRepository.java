package ru.ya.insurance.repository.region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.region.RegionCoefficient;

import java.util.Optional;

@Repository
public interface RegionCoefficientRepository extends JpaRepository<RegionCoefficient, Long> {

    Optional<RegionCoefficient> findByRegion(String regionName);

}