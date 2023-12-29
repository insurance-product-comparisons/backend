package ru.ya.insurance.mapper.newConsultationRequest;

import org.mapstruct.Mapper;
import ru.ya.insurance.dto.newConsultationRequest.NewConsultationRequestDto;
import ru.ya.insurance.model.newConsultationRequest.NewConsultationRequest;

@Mapper
public interface NewConsultationRequestMapper {

    NewConsultationRequestDto newConsultationToNewConsultationDto(NewConsultationRequest newConsultationRequest);

}