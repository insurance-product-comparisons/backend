package ru.ya.insurance.osago.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "base_rates")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "transport_type")
    private String transportType;

    @Column(name = "min_rate")
    private Integer minRate;

    @Column(name = "max_rate")
    private Integer maxRate;
}
