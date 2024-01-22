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
@Table(name = "age_driving_experience_coefficient")
public class AgeDrivingExperienceCoefficient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age_range")
    private String ageRange;

    @Column(name = "driving_experience_range")
    private String drivingExperienceRange;

    @Column(name = "coefficient")
    private BigDecimal coefficient;

}