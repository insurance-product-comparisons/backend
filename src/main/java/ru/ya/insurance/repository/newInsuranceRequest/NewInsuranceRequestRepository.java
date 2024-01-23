package ru.ya.insurance.repository.newInsuranceRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.newInsuranceRequest.NewInsuranceRequest;

@Repository
public interface NewInsuranceRequestRepository extends JpaRepository<NewInsuranceRequest, Long> {
}