package ru.ya.insurance.repository.osago;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ya.insurance.model.osago.OsagoPolicy;

public interface OsagoPolicyRepository extends JpaRepository<OsagoPolicy, Long> {
}