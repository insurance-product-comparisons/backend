package ru.ya.insurance.coefficients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.coefficients.model.RegionCoefficient;

import java.util.List;

@Repository
public interface RegionCoefficientRepository extends JpaRepository<RegionCoefficient, Long> {
    @Query("""
            SELECT e FROM RegionCoefficient  as e
            WHERE (e.number = :number AND e.coefficientExclude <> 0)
             OR e.number LIKE CONCAT( :number, '.%')
            """)
    List<ru.ya.insurance.coefficients.model.RegionCoefficient> findAllByNumberExcludeZeroRegion(String number);

    @Query("""
            SELECT e FROM RegionCoefficient  as e
            WHERE e.name ILIKE CONCAT('%', :query, '%')
            """)
    List<ru.ya.insurance.coefficients.model.RegionCoefficient> findAllByQuery(String query);

}
