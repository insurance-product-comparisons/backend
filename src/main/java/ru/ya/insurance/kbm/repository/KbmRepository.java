package ru.ya.insurance.kbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.kbm.model.Kbm;

@Repository
public interface KbmRepository extends JpaRepository<Kbm, Long> {

}