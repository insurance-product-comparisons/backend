package ru.ya.insurance.model.common;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
// @EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "features")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_id")
    @JsonManagedReference
    private Insurance insurance;

    @Column(name = "feature_name")
    private String name;

    @Column(name = "feature_description")
    private String description;
}
