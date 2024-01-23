package ru.ya.insurance.service.newConsultationRequest.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.model.newConsultationRequest.NewConsultationRequest;
import ru.ya.insurance.repository.newConsultationRequest.NewConsultationRequestRepository;
import ru.ya.insurance.service.newConsultationRequest.NewConsultationRequestService;

@Service
@RequiredArgsConstructor
public class NewConsultationRequestServiceImpl implements NewConsultationRequestService {

    private final NewConsultationRequestRepository newConsultationRequestRepository;

    @Override
    @Transactional
    public NewConsultationRequest addNewConsultationRequest(NewConsultationRequest newConsultationRequest) {
        return newConsultationRequestRepository.save(newConsultationRequest);
    }

}