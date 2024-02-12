package ru.ya.insurance.model.region;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "region")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String region;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id")
    private List<RegionCoefficient> regionCoefficientList;

    private BigDecimal vehicleCoefficient;

    private BigDecimal specialVehicleCoefficient;

    private BigDecimal dmsCoefficient;

}