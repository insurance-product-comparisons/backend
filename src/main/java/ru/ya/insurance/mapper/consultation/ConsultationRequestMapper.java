package ru.ya.insurance.mapper.consultation;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.ya.insurance.dto.consultation.NewConsultationDto;
import ru.ya.insurance.dto.consultation.RequestConsultationDto;
import ru.ya.insurance.model.consultation.ConsultationRequest;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConsultationRequestMapper {

    RequestConsultationDto consultationRequestToRequestConsultationDto(ConsultationRequest consultationRequest);

    ConsultationRequest newConsultationDtoToConsultationRequest(NewConsultationDto newConsultationDto);
}
