package ru.ya.insurance.service.insurance;

import ru.ya.insurance.model.insurance.Insurance;

public interface InsuranceOfferCardService {
    Insurance findInsuranceOfferCardById(Long insuranceId, Long companyId);
}

