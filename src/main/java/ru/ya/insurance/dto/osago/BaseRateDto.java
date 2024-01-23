package ru.ya.insurance.dto.osago;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BaseRateDto {

    private Long id;
    private String transportType;
    private Long minRate;
    private Long maxRate;

}