package ru.ya.insurance.model.osago;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "driver_number_coefficient")
public class DriverNumberCoefficient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "driver_number")
    private String name;

    private BigDecimal coefficient;
}
