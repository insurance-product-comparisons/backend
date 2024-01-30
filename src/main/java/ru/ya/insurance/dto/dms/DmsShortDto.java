package ru.ya.insurance.dto.dms;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DmsShortDto {

    private final Long id;

    private final String insuranceCompany;

    private BigDecimal cost;

}
