package ru.ya.insurance.repository.dms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.dms.DmsBaseRate;

import java.util.List;
import java.util.Optional;

@Repository
public interface DmsBaseRateRepository extends JpaRepository<DmsBaseRate, Long> {

    @Query(value = "select * from dms_base_rate", nativeQuery = true)
    Optional<DmsBaseRate> getDmsBaseRate();
}
