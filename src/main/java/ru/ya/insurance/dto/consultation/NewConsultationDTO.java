package ru.ya.insurance.dto.consultation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class NewConsultationDTO {
    @Pattern(regexp = "^[а-яА-Яa-zA-Zs]+")
    @NotBlank
    @Size(min = 3, max = 20)
    String firstName;

    @Pattern(regexp = "^[а-яА-Яa-zA-Zs]+")
    @NotBlank
    @Size(min = 3, max = 30)
    String lastName;

    @Pattern(regexp = "^[0-9]11")
    @NotBlank
    String phoneNumber;

    @Pattern(regexp = "^[\\p{L}\\p{N}\\p{P}\\p{Z}]+$")
    @NotBlank
    @Size(min = 20, max = 255)
    String situation;

}


