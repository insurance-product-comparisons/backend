package ru.ya.insurance.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.ya.insurance.model.common.Feature;
import ru.ya.insurance.model.common.License;
import ru.ya.insurance.model.common.RequiredDocument;
import ru.ya.insurance.model.common.ValidityPeriod;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class InsuranceDto {
    private String companyName;
    private String companyLogo;
    private List<License> companyLicenses;
    private String insuranceName;
    private String insuranceDescription;
    private Integer insuranceProcessingTime;
    private List<ValidityPeriod> insuranceValidityPeriods;
    private List<Feature> insuranceFeatures;
    private List<RequiredDocument> insuranceRequiredDocuments;
}
