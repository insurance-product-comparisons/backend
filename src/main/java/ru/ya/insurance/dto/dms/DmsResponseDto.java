package ru.ya.insurance.dto.dms;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
public class DmsResponseDto {

    private final String companyLogo;

    private final String companyName;

    private BigDecimal price;

    private final String aboutCompany;

    private int duration;

    private List<String> features;

    private Set<String> requiredDocuments;

    private Set<String> licenses;

    public DmsResponseDto(
            String companyLogo,
            String companyName,
            String aboutCompany,
            BigDecimal price) {
        this.companyLogo = companyLogo;
        this.companyName = companyName;
        this.aboutCompany = aboutCompany;
        this.price = price;
    }

}