package ru.ya.insurance.model.company;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import ru.ya.insurance.model.insurance.Insurance;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Include
    private String name;

    private String description;

    private Double rating;

    private String logo;

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private List<Insurance> insurances;

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Set<License> licenses;
}
