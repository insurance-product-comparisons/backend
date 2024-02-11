package ru.ya.insurance.service.kasko.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.dto.kasko.KaskoPolicyDto;
import ru.ya.insurance.exception.NotFoundException;
import ru.ya.insurance.model.company.Company;
import ru.ya.insurance.model.kasko.KaskoCarModel;
import ru.ya.insurance.model.kasko.KaskoDrivingExperienceCoefficient;
import ru.ya.insurance.model.kasko.KaskoManufactureYearCoefficient;
import ru.ya.insurance.repository.company.CompanyRepository;
import ru.ya.insurance.repository.kasko.KaskoCarModelRepository;
import ru.ya.insurance.repository.kasko.KaskoDrivingExperienceCoefficientRepository;
import ru.ya.insurance.repository.kasko.KaskoManufactureYearCoefficientRepository;
import ru.ya.insurance.service.kasko.KaskoPolicyService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KaskoPolicyServiceImpl implements KaskoPolicyService {

    private final CompanyRepository companyRepository;
    private final KaskoCarModelRepository kaskoCarModelRepository;
    private final KaskoDrivingExperienceCoefficientRepository kaskoDrivingExperienceCoefficientRepository;
    private final KaskoManufactureYearCoefficientRepository kaskoManufactureYearCoefficientRepository;

    @Override
    public List<KaskoPolicyDto> calculatePolicyCost(String brand, String model, int manufactureYear, String drivingExperience) {
        List<KaskoPolicyDto> policies = new ArrayList<>();

        KaskoCarModel kaskoCarModel = kaskoCarModelRepository
                .findByBrandAndModel(brand, model)
                .orElseThrow(() -> new NotFoundException("Коэффициент KaskoCarModel не найден"));

        KaskoManufactureYearCoefficient kaskoManufactureYearCoefficient = kaskoManufactureYearCoefficientRepository
                .findByManufactureYear(manufactureYear)
                .orElseThrow(() -> new NotFoundException("Коэффициент KaskoManufactureYearCoefficient не найден"));

        KaskoDrivingExperienceCoefficient kaskoDrivingExperienceCoefficient = kaskoDrivingExperienceCoefficientRepository
                .findByDrivingExperienceRange(drivingExperience)
                .orElseThrow(() -> new NotFoundException("Коэффициент KaskoDrivingExperienceCoefficient не найден"));

        List<Company> insuranceCompanies = getAllInsuranceCompanies();

        insuranceCompanies.forEach(company -> {
            KaskoPolicyDto policyDTO = new KaskoPolicyDto();

            policyDTO.setInsuranceCompany(company.getName());

            BigDecimal insuranceCompanyCorrectionCoefficient = company.getCoefficient();

            BigDecimal baseKaskoPolicyPrice = BigDecimal.valueOf(3000);
            BigDecimal cost = baseKaskoPolicyPrice
                    .multiply(kaskoCarModel.getCoefficient())
                    .multiply(kaskoDrivingExperienceCoefficient.getCoefficient())
                    .multiply(kaskoManufactureYearCoefficient.getCoefficient())
                    .multiply(insuranceCompanyCorrectionCoefficient);

            policyDTO.setCost(cost.setScale(2, RoundingMode.HALF_UP));
            policies.add(policyDTO);
        });

        return policies;
    }

    private List<Company> getAllInsuranceCompanies() {
        return companyRepository.findAll();
    }

}