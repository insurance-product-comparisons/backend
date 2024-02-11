package ru.ya.insurance.dto.dms;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class DmsShortDto {

    @NotNull(message = "Insurance company is required")
    private final String insuranceCompany;

    @NotNull(message = "Price is required")
    private BigDecimal price;


}
