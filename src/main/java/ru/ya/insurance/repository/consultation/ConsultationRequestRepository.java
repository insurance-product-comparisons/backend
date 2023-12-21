package ru.ya.insurance.repository.consultation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.consultation.ConsultationRequest;

@Repository
public interface ConsultationRequestRepository extends JpaRepository<ConsultationRequest, Long> {
}
