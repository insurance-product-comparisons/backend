package ru.ya.insurance.model.osago;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "base_rate_coefficient")
public class BaseRateCoefficient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transportType;

    @Column(name = "min_coefficient")
    private Long minRate;

    @Column(name = "max_coefficient")
    private Long maxRate;

}