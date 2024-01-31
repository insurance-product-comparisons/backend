package ru.ya.insurance.dto.dms;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
public class DmsResponseDto {

    private final Long id;

    private final String companyLogo;

    private final String companyName;

    private BigDecimal price;

    private final String aboutCompany;

    private int duration;

    private final Set<String> servicesIncluded;

    private final Set<String> documentsRequired;

    private final Set<String> insuranceLicenses;

    public DmsResponseDto(Long id,
                          String companyLogo,
                          String companyName,
                          String aboutCompany,
                          BigDecimal price
    ) {
        this.id = id;
        this.companyLogo = companyLogo;
        this.companyName = companyName;
        this.aboutCompany = aboutCompany;
        this.price = price;
        this.servicesIncluded = new HashSet<>();
        this.documentsRequired = new HashSet<>();
        this.insuranceLicenses = new HashSet<>();
    }
}
