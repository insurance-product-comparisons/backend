package ru.ya.insurance.repository.newConsultationRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.newConsultationRequest.NewConsultationRequest;

@Repository
public interface NewConsultationRequestRepository extends JpaRepository<NewConsultationRequest, Long> {
}