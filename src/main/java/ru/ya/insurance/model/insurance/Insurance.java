package ru.ya.insurance.model.insurance;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import ru.ya.insurance.enums.InsuranceType;
import ru.ya.insurance.model.company.Company;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "insurances")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonManagedReference
    @EqualsAndHashCode.Include
    private Company company;

    @Enumerated(EnumType.STRING)
    @EqualsAndHashCode.Include
    private InsuranceType type;

    @EqualsAndHashCode.Include
    private String name;

    private String description;

    @Column(name = "processing_time")
    private Integer processingTime;

    @OneToMany(mappedBy = "insurance")
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Set<RequiredDocument> requiredDocuments;

    @OneToMany(mappedBy = "insurance")
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Set<Feature> features;

    @OneToMany(mappedBy = "insurance", fetch = FetchType.LAZY)
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Set<ValidityPeriod> validityPeriods;
}
