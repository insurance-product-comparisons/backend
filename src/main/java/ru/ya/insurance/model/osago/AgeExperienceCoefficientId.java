package ru.ya.insurance.model.osago;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgeExperienceCoefficientId implements Serializable {

    private Long ageId;
    private Long experienceId;

}