package ru.ya.insurance.model.common;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double rating;

    private String logo;

    @OneToMany(mappedBy = "company")
    private List<Insurance> insurances;

    @OneToMany(mappedBy = "company")
    private List<License> licenses;
}
