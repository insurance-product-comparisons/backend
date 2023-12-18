package ru.ya.insurance.model.osago;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "region_coefficient")
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
