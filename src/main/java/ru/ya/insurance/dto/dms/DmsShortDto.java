package ru.ya.insurance.dto.dms;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DmsShortDto {

    private final String insuranceCompany;

    private BigDecimal price;

    public DmsShortDto(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }
}
