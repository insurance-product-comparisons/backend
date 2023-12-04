package ru.ya.insurance.coefficients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionCoefficientRepository extends JpaRepository<ru.ya.insurance.coefficients.model.RegionCoefficient, Long> {
    @Query("""
            SELECT e FROM RegionCoefficient  as e
            WHERE (e.number = :number AND e.coefficientExclude <> 0)
             OR e.number LIKE CONCAT( :number, '.%')
            """)
    List<ru.ya.insurance.coefficients.model.RegionCoefficient> findAllByNumber(String number);

    @Query("""
            SELECT e FROM RegionCoefficient  as e
            WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :query, '%'))
            """)
    List<ru.ya.insurance.coefficients.model.RegionCoefficient> findAllByQuery(String query);

}
