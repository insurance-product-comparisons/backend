package ru.ya.insurance.model.dms;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "age_dms_coefficients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgeDmsCoefficient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;

    private BigDecimal coefficient;

}