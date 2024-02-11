package ru.ya.insurance.repository.kasko;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.kasko.KaskoCarModel;

import java.util.Optional;

@Repository
public interface KaskoCarModelRepository extends JpaRepository<KaskoCarModel, Long> {

    Optional<KaskoCarModel> findByBrandAndModel(String brand, String model);

}