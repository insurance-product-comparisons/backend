package ru.ya.insurance.model.osago;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "new_insurance_request")
public class NewInsuranceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String phoneNumber;

    private String email;

    private String situation;

    @Column(name = "as_a_gift", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean insuranceAsAGift;

}