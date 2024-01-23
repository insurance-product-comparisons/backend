package ru.ya.insurance.dto.kasko;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KaskoCarModelDto {

    private Long id;
    @Size(min = 1, max = 255)
    private String brand;

    @Size(min = 1, max = 255)
    private String model;

    private BigDecimal coefficient;

}