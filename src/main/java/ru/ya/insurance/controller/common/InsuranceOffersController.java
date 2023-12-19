package ru.ya.insurance.controller.common;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.dto.common.InsuranceDto;
import ru.ya.insurance.exception.NotFoundException;
import ru.ya.insurance.mapper.common.InsuranceOfferCardMapper;
import ru.ya.insurance.model.common.Insurance;
import ru.ya.insurance.repository.common.InsuranceRepository;
import ru.ya.insurance.service.common.InsuranceOfferService;

import java.util.Optional;

/**
 * Карточки предложений от страховых компаний
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/common")
public class InsuranceOffersController {
    private final InsuranceOfferService insuranceOfferService;
    private final InsuranceOfferCardMapper insuranceOfferCardMapper;

    @GetMapping("/company/{companyId}/insurance/{insuranceId}")
    public InsuranceDto getInsuranceOffers(@PathVariable Long companyId,
                                           @PathVariable Long insuranceId) {

        Insurance insurance = insuranceOfferService.findInsuranceOfferCardById(insuranceId, companyId);

        InsuranceDto insuranceDto = insuranceOfferCardMapper.insuranceToInsuranceDto(insurance);
        return insuranceDto;
    }
}
