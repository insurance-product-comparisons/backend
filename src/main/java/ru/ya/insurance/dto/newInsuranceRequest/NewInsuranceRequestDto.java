package ru.ya.insurance.dto.newInsuranceRequest;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewInsuranceRequestDto {

    private Long id;

    @Pattern(regexp = "^[а-яА-Яa-zA-Z- ]{3,256}$",
            message = "Полное имя должно быть длиной от 3 до 256 символов и содержать только буквы, дефис и пробел")
    private String fullName;

    @Pattern(regexp = "^\\+7[0-9]{10}$",
            message = "Номер телефона должен начинаться с +7 и быть 12 символов в длину")
    private String phoneNumber;

    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]+$",
            message = "Введен некорректный Email")
    private String email;

    @Size(min = 1, max = 500,
            message = "Описание ситуации должно быть длиной от 1 до 500 символов")
    private String situation;

    private boolean insuranceAsAGift;

}