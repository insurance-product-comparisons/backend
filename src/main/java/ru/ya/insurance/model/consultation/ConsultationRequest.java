package ru.ya.insurance.model.consultation;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "request_for_consultation")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String phoneNumber;
    @Column
    private String situation;
}
