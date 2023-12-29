package ru.ya.insurance.service.newInsuranceRequest;

import ru.ya.insurance.dto.newInsuranceRequest.NewInsuranceRequestDto;
import ru.ya.insurance.model.newInsuranceRequest.NewInsuranceRequest;

public interface NewInsuranceRequestService {

    NewInsuranceRequestDto addNewInsuranceRequest(NewInsuranceRequest newInsuranceRequest);

}