package ru.ya.insurance.repository.dms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.dms.AgeDmsCoefficient;

import java.util.Optional;

@Repository
public interface AgeDmsCoefficientRepository extends JpaRepository<AgeDmsCoefficient, Long> {

    Optional<AgeDmsCoefficient> findByAge(Integer age);
}