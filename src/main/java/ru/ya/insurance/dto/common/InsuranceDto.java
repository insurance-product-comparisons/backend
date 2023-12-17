package ru.ya.insurance.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.ya.insurance.enums.DocumentType;

import java.util.List;

// Не финальный Dto
@Getter
@Setter
@AllArgsConstructor
public class InsuranceDto {
    private String companyName;
    private String companyLogo;
    private String insuranceName;
    private String insuranceDescription;
    private Integer processingTime;
    private Integer insuranceValidityPeriod;
    private List<String> insuranceFeatures;
    private List<DocumentType> insuranceRequiredDocuments;
    private List<String> companyLicenses;
}
