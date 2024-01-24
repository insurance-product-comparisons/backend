package ru.ya.insurance.dto.dms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DmsRequestDto {

    @NotNull
    @PositiveOrZero
    private final int age;

    @NotNull
    @PositiveOrZero
    private final int insuranceTerm;

    @NotBlank
    @Size(max = 255)
    private final String region;

    @Size(max = 255)
    private final String settlement;

}
