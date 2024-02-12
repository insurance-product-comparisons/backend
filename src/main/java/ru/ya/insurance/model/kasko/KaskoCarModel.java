package ru.ya.insurance.model.kasko;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "kasko_car_models")
public class KaskoCarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private BigDecimal coefficient;

    public KaskoCarModel(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

}