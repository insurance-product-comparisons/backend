package ru.ya.insurance.service.common.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.exception.NotFoundException;
import ru.ya.insurance.model.common.Insurance;
import ru.ya.insurance.repository.common.InsuranceRepository;
import ru.ya.insurance.service.common.InsuranceOfferCardService;

@Service
@RequiredArgsConstructor
public class InsuranceOfferCardServiceImpl implements InsuranceOfferCardService {
    private final InsuranceRepository insuranceRepository;

    @Transactional(readOnly = true)
    @Override
    public Insurance findInsuranceOfferCardById(Long companyId, Long insuranceId) {

        return insuranceRepository.findByIdAndCompanyId(insuranceId, companyId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Not Found. insuranceId=%d, companyId=%d", insuranceId, companyId))
                );
    }
}
