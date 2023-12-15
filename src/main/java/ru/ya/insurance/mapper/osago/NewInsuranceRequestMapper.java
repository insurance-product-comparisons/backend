package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.ya.insurance.dto.osago.NewInsuranceRequestDto;
import ru.ya.insurance.model.osago.NewInsuranceRequest;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NewInsuranceRequestMapper {

    NewInsuranceRequestDto newInsuranceRequestToNewInsuranceRequestDto(NewInsuranceRequest newInsuranceRequest);

    NewInsuranceRequest newInsuranceRequestDtoToNewInsuranceRequest(NewInsuranceRequestDto newInsuranceRequestDto);

}