package ru.ya.insurance.service.insurance.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.exception.NotFoundException;
import ru.ya.insurance.model.insurance.Insurance;
import ru.ya.insurance.repository.insurance.InsuranceRepository;
import ru.ya.insurance.service.insurance.InsuranceOfferCardService;

@Service
@RequiredArgsConstructor
public class InsuranceOfferCardServiceImpl implements InsuranceOfferCardService {
    private final InsuranceRepository insuranceRepository;

    @Transactional(readOnly = true)
    @Override
    public Insurance findInsuranceOfferCardById(Long insuranceId, Long companyId) {

        return insuranceRepository.findByIdAndCompanyId(insuranceId, companyId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Not Found. insuranceId=%d, companyId=%d", insuranceId, companyId))
                );
    }
}
