package ru.ya.insurance.service.consultation;

import ru.ya.insurance.dto.consultation.NewConsultationDto;
import ru.ya.insurance.dto.consultation.RequestConsultationDto;

public interface ConsultationService {

    RequestConsultationDto save(NewConsultationDto newConsultationDto);
}
