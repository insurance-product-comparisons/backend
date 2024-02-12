package ru.ya.insurance.model.osago;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "kmb_coefficient")
public class KbmCoefficient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kbm")
    private String kbmClass;

    private BigDecimal coefficient;

    public KbmCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }
}