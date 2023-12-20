package ru.ya.insurance.model.insurance;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import ru.ya.insurance.model.insurance.Insurance;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "validity_periods")
public class ValidityPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_id")
    @JsonManagedReference
    @EqualsAndHashCode.Include
    private Insurance insurance;

    @Column(name = "validity_period")
    @EqualsAndHashCode.Include
    private Integer validityPeriod;
}
