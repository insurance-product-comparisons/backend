package ru.ya.insurance.repository.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ya.insurance.model.company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}