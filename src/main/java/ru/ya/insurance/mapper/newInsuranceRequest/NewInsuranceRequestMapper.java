package ru.ya.insurance.mapper.newInsuranceRequest;

import org.mapstruct.Mapper;
import ru.ya.insurance.dto.newInsuranceRequest.NewInsuranceRequestDto;
import ru.ya.insurance.model.newInsuranceRequest.NewInsuranceRequest;

@Mapper
public interface NewInsuranceRequestMapper {

    NewInsuranceRequest newInsuranceRequestDtoToNewInsuranceRequest(NewInsuranceRequestDto newInsuranceRequestDto);

}