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
@Table(name = "required_documents")
public class RequiredDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_id")
    @JsonManagedReference
    private Insurance insurance;

    private String document;
}
