package ru.ya.insurance.dto.osago;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OsagoPolicyDto {
    private String insuranceCompany;
    private BigDecimal cost;
}