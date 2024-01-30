package ru.ya.insurance.dto.dms;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class DmsResponseDto {

    private final Long id;

    private final String companyLogo;

    private final String companyName;

    private BigDecimal price;

    private final String aboutCompany;

    private int duration;

    private final List<String> servicesIncluded;

    private final List<String> documentsRequired;

    private final List<String> insuranceLicenses;

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
        this.servicesIncluded = new ArrayList<>();
        this.documentsRequired = new ArrayList<>();
        this.insuranceLicenses = new ArrayList<>();
    }
}
