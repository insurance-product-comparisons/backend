package ru.ya.insurance.model.dms;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "age")
    private int age;

    @Column(name = "insurance_term")
    private int insuranceTerm;

    @Column(name = "region")
    private String region;

    @Column(name = "settlement")
    private String settlement;

}
