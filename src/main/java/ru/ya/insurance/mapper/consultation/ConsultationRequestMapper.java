package ru.ya.insurance.mapper.consultation;

import org.mapstruct.Mapper;
import ru.ya.insurance.dto.consultation.NewConsultationDto;
import ru.ya.insurance.dto.consultation.RequestConsultationDto;
import ru.ya.insurance.model.consultation.ConsultationRequest;

@Mapper
public interface ConsultationRequestMapper {

    RequestConsultationDto consultationRequestToRequestConsultationDto(ConsultationRequest consultationRequest);

    ConsultationRequest newConsultationDtoToConsultationRequest(NewConsultationDto newConsultationDto);
}
