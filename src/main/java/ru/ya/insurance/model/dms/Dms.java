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
@Table(name = "dms_insurance")
@NoArgsConstructor
@AllArgsConstructor
public class Dms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(name = "base_rate")
    private BigDecimal baseRate;

}
