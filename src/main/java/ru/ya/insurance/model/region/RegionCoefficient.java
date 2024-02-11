package ru.ya.insurance.model.region;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "region_coefficient")
public class RegionCoefficient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String region;

    private BigDecimal vehicleCoefficient;

    private BigDecimal specialVehicleCoefficient;

    private BigDecimal dmsCoefficient;

    public RegionCoefficient(Long id, String region, BigDecimal dmsCoefficient) {
        this.id = id;
        this.region = region;
        this.dmsCoefficient = dmsCoefficient;
    }
}