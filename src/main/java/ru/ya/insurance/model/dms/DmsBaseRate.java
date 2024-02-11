package ru.ya.insurance.model.dms;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.ya.insurance.model.company.Company;
import ru.ya.insurance.model.region.Region;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "dms_base_rate")
@NoArgsConstructor
@AllArgsConstructor
public class DmsBaseRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(name = "base_rate")
    private BigDecimal baseRate;

}
