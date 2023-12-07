package ru.ya.insurance.ageExperience.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AgeExperienceCoefficientId implements Serializable {

    private Long ageId;
    private Long experienceId;

}