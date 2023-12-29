package ru.ya.insurance.dto.newConsultationRequest;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewConsultationRequestDto {

    private Long id;

    @Pattern(regexp = "^[а-яА-Яa-zA-Z- ]{2,256}$",
            message = "Имя должно быть длиной от 2 до 256 символов и содержать только буквы, дефис и пробел")
    private String firstName;

    @Pattern(regexp = "^[а-яА-Яa-zA-Z- ]{2,256}$",
            message = "Фамилия должна быть длиной от 2 до 256 символов и содержать только буквы, дефис и пробел")
    private String lastName;

    @Pattern(regexp = "^\\+7[0-9]{10}$",
            message = "Номер телефона должен начинаться с +7 и быть 12 символов в длину")
    private String phoneNumber;

    @Size(min = 1, max = 500,
            message = "Описание ситуации должно быть длиной от 1 до 500 символов")
    private String situation;

}