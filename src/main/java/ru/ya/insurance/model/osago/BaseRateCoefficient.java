package ru.ya.insurance.model.osago;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "base_rate_coefficient")
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
