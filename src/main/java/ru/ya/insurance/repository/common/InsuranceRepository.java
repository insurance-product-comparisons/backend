package ru.ya.insurance.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.common.Insurance;

import java.util.Optional;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    @Query("SELECT i " +
            "FROM Insurance i " +
            "JOIN FETCH i.company c " +
            "JOIN FETCH c.licenses l" +
            "JOIN FETCH i.features f " +
            "JOIN FETCH i.validityPeriods vp " +
            "JOIN FETCH i.requiredDocuments rd " +
            "WHERE i.id = :insuranceId AND i.company.id = :companyId")
    Optional<Insurance> findByIdAndCompanyId(Long insuranceId, Long companyId);
}
