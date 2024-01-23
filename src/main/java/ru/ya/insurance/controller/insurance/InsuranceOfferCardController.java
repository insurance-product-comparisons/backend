package ru.ya.insurance.controller.insurance;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.dto.insurance.InsuranceOfferCardDto;
import ru.ya.insurance.mapper.insurance.InsuranceOfferCardMapper;
import ru.ya.insurance.model.insurance.Insurance;
import ru.ya.insurance.service.insurance.InsuranceOfferCardService;

/**
 * Карточки предложений от страховых компаний
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/insurance-offer-card")
public class InsuranceOfferCardController {
    private final InsuranceOfferCardService insuranceOfferService;
    private final InsuranceOfferCardMapper insuranceOfferCardMapper;

    @GetMapping("/insurance/{insuranceId}/company/{companyId}")
    public InsuranceOfferCardDto getInsuranceOffers(@PathVariable Long insuranceId,
                                                    @PathVariable Long companyId) {

        Insurance insurance = insuranceOfferService.findInsuranceOfferCardById(insuranceId, companyId);

        return insuranceOfferCardMapper.insuranceToInsuranceDto(insurance);
    }
}
