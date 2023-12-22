package ru.ya.insurance.dto.consultation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestConsultationDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String situation;
}
