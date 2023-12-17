package ru.ya.insurance.model.common;

import jakarta.persistence.*;
import lombok.*;
import ru.ya.insurance.enums.InsuranceType;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "insurances")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Enumerated(EnumType.STRING)
    private InsuranceType type;

    private String name;

    private String description;

    @Column(name = "processing_time")
    private Integer processingTime;

    @Column(name = "validity_period")
    private Integer validityPeriod;

    @OneToMany(mappedBy = "insurance")
    private Set<RequiredDocument> requiredDocuments;

    @OneToMany(mappedBy = "insurance")
    private Set<Feature> features;

    @OneToMany(mappedBy = "insurance")
    private List<ValidityPeriod> validityPeriods;
}
