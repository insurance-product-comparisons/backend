package ru.ya.insurance.model.osago;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "age_experience_coefficient")
@IdClass(AgeExperienceCoefficientId.class)
public class AgeExperienceCoefficient {

    @Id
    @Column(name = "age_id")
    private Long ageId;

    @Id
    @Column(name = "experience_id")
    private Long experienceId;

    @Column(name = "coefficient")
    private BigDecimal coefficient;

}