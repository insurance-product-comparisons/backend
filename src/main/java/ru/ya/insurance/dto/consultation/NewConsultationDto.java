package ru.ya.insurance.dto.consultation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewConsultationDto {
    @Pattern(regexp = "^[а-яА-Яa-zA-Zs]+",
        message = "Имя может содержать только буквы и пробел, от 3 до 20 символов")
    @NotBlank
    @Size(min = 3, max = 20)
    String firstName;

    @Pattern(regexp = "^[а-яА-Яa-zA-Zs]+",
        message = "Фамилия может содержать только буквы и пробел, от 3 до 30 символов")
    @NotBlank
    @Size(min = 3, max = 30)
    String lastName;

    @Pattern(regexp = "^\\+7[0-9]{10}$",
        message = "Номер телефона должен начинаться с +7 и быть 12 символов в длину")
    @NotBlank(message = "Телефонный номер не может быть пустым")
    String phoneNumber;

    @Pattern(regexp = "^[\\p{L}\\p{N}\\p{P}\\p{Z}]+$",
        message = "Описание должно быть не меньше 20 и не больше 255 символов")
    @NotBlank(message = "Описание ситуации страхования не может быть пустым")
    @Size(min = 20, max = 255)
    String situation;
}


