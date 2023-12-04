package ru.ya.insurance.coefficients.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Коэффициент страховых тарифов в зависимости от территории преимущественного
 * использования транспортного средства
 */
@Entity
@Table(name = "region_coefficients")
@Data
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
    @Column(name = "coefficient_exclude")
    private BigDecimal coefficientExclude;
    @Column(name = "coefficient_include")
    private BigDecimal coefficientInclude;
}
