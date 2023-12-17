package ru.ya.insurance.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.common.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
