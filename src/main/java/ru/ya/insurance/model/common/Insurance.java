package ru.ya.insurance.model.common;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import ru.ya.insurance.enums.InsuranceType;

import java.util.Set;

@Entity
@Getter
@Setter
// @EqualsAndHashCode
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
    private Company company;

    @Enumerated(EnumType.STRING)
    private InsuranceType type;

    private String name;

    private String description;

    @Column(name = "processing_time")
    private Integer processingTime;

    @OneToMany(mappedBy = "insurance")
    @JsonBackReference
    private Set<RequiredDocument> requiredDocuments;

    @OneToMany(mappedBy = "insurance")
    @JsonBackReference
    private Set<Feature> features;

    @OneToMany(mappedBy = "insurance")
    @JsonBackReference
    private Set<ValidityPeriod> validityPeriods;
}
