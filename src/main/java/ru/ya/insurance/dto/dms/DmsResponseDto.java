package ru.ya.insurance.dto.dms;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DmsResponseDto {

    private final String insuranceCompany;

    private final BigDecimal cost;

}
