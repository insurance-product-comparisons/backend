package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import ru.ya.insurance.dto.osago.NewInsuranceRequestDto;
import ru.ya.insurance.model.osago.NewInsuranceRequest;

@Mapper
public interface NewInsuranceRequestMapper {

    NewInsuranceRequest newInsuranceRequestDtoToNewInsuranceRequest(NewInsuranceRequestDto newInsuranceRequestDto);

}