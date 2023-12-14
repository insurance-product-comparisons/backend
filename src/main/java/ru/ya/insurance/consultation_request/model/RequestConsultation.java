package ru.ya.insurance.consultation_request.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "request_for_consultation", schema = "public")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestConsultation {
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
