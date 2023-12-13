package ru.ya.insurance.coefficients.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Коэффициент страховых тарифов в зависимости от территории преимущественного
 * использования транспортного средства:
 * number - Номер по порядку из Приложения №2 к Указанию Банка России от 28 июля 2020 года N 5515-У;
 * coefficientExclude - Коэффициент КТ для транспортных средств, за исключением Тракторы, самоходные дорожно-строительные...;
 * coefficientInclude - Коэффициент КТ для тракторов, самоходных и дорожно-строительных...;
 */
@Entity
@Table(name = "region_coefficients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegionCoefficient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String year;
    private String number;
    @Column(name = "territory")
    private String name;
    private BigDecimal coefficientExclude;
    private BigDecimal coefficientInclude;
}
