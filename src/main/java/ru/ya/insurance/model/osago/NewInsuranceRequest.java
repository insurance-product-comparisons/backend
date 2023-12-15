package ru.ya.insurance.model.osago;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "new_insurance_request")
public class NewInsuranceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "situation")
    private String situation;

    @Column(name = "gift", columnDefinition = "BOOLEAN DEFAULT FALSE")
    boolean isGift;

}