package ru.ya.insurance.service.common;

import ru.ya.insurance.model.common.Insurance;

public interface InsuranceOfferService {
    Insurance findInsuranceOfferCardById(Long companyId, Long insuranceId);
}

