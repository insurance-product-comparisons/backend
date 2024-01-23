package ru.ya.insurance.repository.osago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.osago.KbmCoefficient;

import java.util.Optional;

@Repository
public interface KbmCoefficientRepository extends JpaRepository<KbmCoefficient, Long> {

    Optional<KbmCoefficient> findByKbmClass(String kbmClass);

}