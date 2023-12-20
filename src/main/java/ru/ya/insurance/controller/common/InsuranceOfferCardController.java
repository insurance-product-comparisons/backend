package ru.ya.insurance.controller.common;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.dto.common.InsuranceOfferCardDto;
import ru.ya.insurance.mapper.common.InsuranceOfferCardMapper;
import ru.ya.insurance.model.common.Insurance;
import ru.ya.insurance.service.common.InsuranceOfferCardService;

/**
 * Карточки предложений от страховых компаний
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/common")
public class InsuranceOfferCardController {
    private final InsuranceOfferCardService insuranceOfferService;
    private final InsuranceOfferCardMapper insuranceOfferCardMapper;

    @GetMapping("/company/{companyId}/insurance/{insuranceId}")
    public InsuranceOfferCardDto getInsuranceOffers(@PathVariable Long companyId,
                                                    @PathVariable Long insuranceId) {

        Insurance insurance = insuranceOfferService.findInsuranceOfferCardById(insuranceId, companyId);

        return insuranceOfferCardMapper.insuranceToInsuranceDto(insurance);
    }
}
