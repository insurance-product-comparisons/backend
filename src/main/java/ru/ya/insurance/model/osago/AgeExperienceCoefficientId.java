package ru.ya.insurance.model.osago;

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