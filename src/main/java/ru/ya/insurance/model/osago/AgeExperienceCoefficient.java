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
@Table(name = "age_experience_coefficient")
@IdClass(AgeExperienceCoefficientId.class)
public class AgeExperienceCoefficient {

    @Id
    @Column(name = "age_id")
    private Long ageId;

    @Id
    private Long experienceId;

    private BigDecimal coefficient;

}