package ru.ya.insurance.model.osago;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "engine_power_coefficient")
public class EnginePowerCoefficient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "engine_power")
    private String power;

    @Column(name = "coefficient")
    private Double coefficient;
}
