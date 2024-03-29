package ru.ya.insurance.model.insurance;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "features")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_id")
    @JsonManagedReference
    @EqualsAndHashCode.Include
    private Insurance insurance;

    @Column(name = "feature_name")
    @EqualsAndHashCode.Include
    private String name;

    @Column(name = "feature_description")
    private String description;

    public Feature(String name) {
        this.name = name;
    }
}
