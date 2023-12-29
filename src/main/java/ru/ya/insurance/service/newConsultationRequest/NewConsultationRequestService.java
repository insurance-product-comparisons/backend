package ru.ya.insurance.service.newConsultationRequest;

import ru.ya.insurance.dto.newConsultationRequest.NewConsultationRequestDto;
import ru.ya.insurance.model.newConsultationRequest.NewConsultationRequest;

public interface NewConsultationRequestService {

    NewConsultationRequestDto addNewConsultationRequest(NewConsultationRequest newConsultationRequest);

}