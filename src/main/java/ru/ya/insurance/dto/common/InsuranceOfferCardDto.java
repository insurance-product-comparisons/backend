package ru.ya.insurance.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class InsuranceOfferCardDto {
    private String companyLogo;
    private String companyName;
    private List<String> companyLicenses;
    private String insuranceName;
    private String insuranceDescription;
    private List<Integer> insuranceValidityPeriods;
    private List<FeatureDto> insuranceFeatures;
    private List<String> insuranceRequiredDocuments;
    private Integer insuranceProcessingTime;
}
