package ru.ya.insurance.model.osago;

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

    @Column(name = "driver_number")
    private String name;

    @Column(name = "coefficient")
    private BigDecimal coefficient;
}
