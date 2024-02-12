package ru.ya.insurance.repository.region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.region.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}
