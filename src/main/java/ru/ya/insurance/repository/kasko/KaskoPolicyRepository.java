package ru.ya.insurance.repository.kasko;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.kasko.KaskoPolicy;

@Repository
public interface KaskoPolicyRepository extends JpaRepository<KaskoPolicy, Long> {
}