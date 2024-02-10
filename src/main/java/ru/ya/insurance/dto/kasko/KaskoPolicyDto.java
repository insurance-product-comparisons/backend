package ru.ya.insurance.dto.kasko;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class KaskoPolicyDto {
    private String insuranceCompany;
    private BigDecimal cost;
}