package ru.ya.insurance.controller.common;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.dto.common.InsuranceDto;

/**
 * Карточки предложений от страховых компаний
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/common")
public class InsuranceOffersController {

    @GetMapping("/company/{companyId}/insurance/{insuranceId}")
    public InsuranceDto getInsuranceOffers(@PathVariable Long companyId,
                                           @PathVariable Long insuranceId) {
        return null;
    }
}
