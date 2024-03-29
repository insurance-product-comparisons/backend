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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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

    public Insurance(InsuranceType type, Set<Feature> features, Set<RequiredDocument> requiredDocuments) {
        this.type = type;
        this.features = features;
        this.requiredDocuments = requiredDocuments;
    }
}
