package ru.ya.insurance.service.common;

import ru.ya.insurance.model.common.Insurance;

public interface InsuranceOfferCardService {
    Insurance findInsuranceOfferCardById(Long companyId, Long insuranceId);
}

