package ru.ya.insurance.model.osago;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "base_rate_coefficient")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseRateCoefficient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "transport_type")
    private String transportType;

    @Column(name = "min_coefficient")
    private Integer minRate;

    @Column(name = "max_coefficient")
    private Integer maxRate;
}
