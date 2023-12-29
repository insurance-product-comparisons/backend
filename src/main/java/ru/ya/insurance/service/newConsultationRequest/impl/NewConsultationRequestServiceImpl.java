package ru.ya.insurance.service.newConsultationRequest.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.dto.newConsultationRequest.NewConsultationRequestDto;
import ru.ya.insurance.mapper.newConsultationRequest.NewConsultationRequestMapper;
import ru.ya.insurance.model.newConsultationRequest.NewConsultationRequest;
import ru.ya.insurance.repository.newConsultationRequest.NewConsultationRequestRepository;
import ru.ya.insurance.service.newConsultationRequest.NewConsultationRequestService;

@Service
@RequiredArgsConstructor
public class NewConsultationRequestServiceImpl implements NewConsultationRequestService {

    private final NewConsultationRequestRepository newConsultationRequestRepository;
    private final NewConsultationRequestMapper newConsultationRequestMapper;

    @Override
    @Transactional
    public NewConsultationRequestDto addNewConsultationRequest(NewConsultationRequest newConsultationRequest) {
        return newConsultationRequestMapper.newConsultationToNewConsultationDto((
                newConsultationRequestRepository.save(newConsultationRequest)));
    }

}