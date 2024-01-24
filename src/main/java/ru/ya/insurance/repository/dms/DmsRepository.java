package ru.ya.insurance.repository.dms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.dms.Dms;

import java.util.List;

@Repository
public interface DmsRepository extends JpaRepository<Dms, Long> {

    List<Dms> findAllByAgeAndInsuranceTermAndRegion(int age, int insuranceTerm, String region);
}
