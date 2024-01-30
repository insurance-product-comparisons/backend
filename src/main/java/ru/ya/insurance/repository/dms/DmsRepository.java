package ru.ya.insurance.repository.dms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.dms.Dms;

import java.util.List;

@Repository
public interface DmsRepository extends JpaRepository<Dms, Long> {


    @Query(nativeQuery = true, value = "SELECT d.* FROM dms d JOIN region r ON d.region_id = r.id " +
            " WHERE r.region_name = region ORDER BY d.base_rate;")
    List<Dms> findAllDmsByRegionOrderByBaseRate(String region);
}
