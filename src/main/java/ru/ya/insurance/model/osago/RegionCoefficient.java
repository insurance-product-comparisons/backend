package ru.ya.insurance.model.osago;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "region_coefficient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegionCoefficient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year")
    private String year;

    @Column(name = "number")
    private String number;

    @Column(name = "region")
    private String name;

    @Column(name = "coefficient_exclude")
    private BigDecimal coefficientExclude;

    @Column(name = "coefficient_include")
    private BigDecimal coefficientInclude;
}
