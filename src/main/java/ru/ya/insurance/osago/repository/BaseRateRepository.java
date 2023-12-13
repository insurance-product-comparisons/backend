package ru.ya.insurance.osago.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.osago.model.BaseRate;

@Repository
public interface BaseRateRepository extends JpaRepository<BaseRate, Long> {
}
