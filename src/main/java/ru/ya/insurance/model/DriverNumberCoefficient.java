package ru.ya.insurance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "driver_number_coefficient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverNumberCoefficient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "coefficient_name")
    private String name;

    @Column(name = "coefficient_value")
    private BigDecimal coefficient;
}
