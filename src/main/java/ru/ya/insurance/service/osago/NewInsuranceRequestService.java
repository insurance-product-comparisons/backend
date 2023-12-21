package ru.ya.insurance.service.osago;

import ru.ya.insurance.dto.osago.NewInsuranceRequestDto;
import ru.ya.insurance.model.osago.NewInsuranceRequest;

public interface NewInsuranceRequestService {

    NewInsuranceRequest addNewInsuranceRequest(NewInsuranceRequestDto newInsuranceRequestDto);

}