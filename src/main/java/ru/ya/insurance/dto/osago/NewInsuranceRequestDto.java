package ru.ya.insurance.dto.osago;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewInsuranceRequestDto {

    private Long id;

    @Pattern(regexp = "^[а-яА-Яa-zA-Z ]{10,50}$",
            message = "Полное имя должно быть длиной от 10 до 50 символов и содержать только буквы и пробел")
    private String fullName;

    @Pattern(regexp = "^7[0-9]{10}$",
            message = "Номер телефона должен начинаться с 7 и быть 11 цифр в длину")
    private String phoneNumber;

    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]+$",
            message = "Введен некорректный Email")
    private String email;

    @Size(min = 20, max = 255,
            message = "Описание ситуации должно быть длиной от 20 до 255 символов")
    private String situation;

    private boolean isGift = false;

}