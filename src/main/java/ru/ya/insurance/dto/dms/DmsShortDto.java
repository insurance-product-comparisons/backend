package ru.ya.insurance.dto.dms;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DmsShortDto {

    @NotNull(message = "Insurance company is required")
    private final String insuranceCompany;

    @NotNull(message = "Price is required")
    private BigDecimal price;

    public DmsShortDto(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public DmsShortDto(String insuranceCompany, BigDecimal price) {
        this.insuranceCompany = insuranceCompany;
        this.price = price;
    }
}
