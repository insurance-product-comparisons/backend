package ru.ya.insurance.service.osago.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.dto.osago.OsagoPolicyDto;
import ru.ya.insurance.exception.NotFoundException;
import ru.ya.insurance.model.company.Company;
import ru.ya.insurance.model.osago.*;
import ru.ya.insurance.model.region.RegionCoefficient;
import ru.ya.insurance.repository.company.CompanyRepository;
import ru.ya.insurance.repository.osago.*;
import ru.ya.insurance.repository.region.RegionCoefficientRepository;
import ru.ya.insurance.service.osago.OsagoPolicyService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OsagoPolicyServiceImpl implements OsagoPolicyService {

    private final AgeDrivingExperienceCoefficientRepository ageDrivingExperienceCoefficientRepository;
    private final BaseRateCoefficientRepository baseRateCoefficientRepository;
    private final CompanyRepository companyRepository;
    private final DriverNumberCoefficientRepository driverNumberCoefficientRepository;
    private final EnginePowerCoefficientRepository enginePowerCoefficientRepository;
    private final KbmCoefficientRepository kbmCoefficientRepository;
    private final RegionCoefficientRepository regionCoefficientRepository;
    private final SeasonCoefficientRepository seasonCoefficientRepository;


    @Override
    public List<OsagoPolicyDto> calculatePolicyCost(
            String ageRange, String drivingExperienceRange, String transportType, String driverNumber,
            String enginePower, String kbmClass, String regionName, String seasonPeriod) {
        List<OsagoPolicyDto> policies = new ArrayList<>();

        AgeDrivingExperienceCoefficient ageDrivingExperienceCoefficient = ageDrivingExperienceCoefficientRepository
                .findByAgeRangeAndDrivingExperienceRange(ageRange, drivingExperienceRange)
                .orElseThrow(() -> new NotFoundException("Коэффициент AgeDrivingExperienceCoefficient не найден"));

        BaseRateCoefficient baseRateCoefficient = baseRateCoefficientRepository
                .findByTransportType(transportType)
                .orElseThrow(() -> new NotFoundException("Коэффициент BaseRateCoefficient не найден"));

        DriverNumberCoefficient driverNumberCoefficient = driverNumberCoefficientRepository
                .findByName(driverNumber)
                .orElseThrow(() -> new NotFoundException("Коэффициент DriverNumberCoefficient не найден"));

        EnginePowerCoefficient enginePowerCoefficient = enginePowerCoefficientRepository
                .findByPower(enginePower)
                .orElseThrow(() -> new NotFoundException("Коэффициент EnginePowerCoefficient не найден"));

        KbmCoefficient kbmCoefficient = kbmCoefficientRepository
                .findByKbmClass(kbmClass)
                .orElseThrow(() -> new NotFoundException("Коэффициент KbmCoefficient не найден"));

        RegionCoefficient regionCoefficient = regionCoefficientRepository
                .findByRegion(regionName)
                .orElseThrow(() -> new NotFoundException("Коэффициент RegionCoefficient не найден"));

        SeasonCoefficient seasonCoefficient = seasonCoefficientRepository
                .findByUsagePeriod(seasonPeriod)
                .orElseThrow(() -> new NotFoundException("Коэффициент SeasonCoefficient не найден"));

        List<Company> insuranceCompanies = getAllInsuranceCompanies();

        for (int i = 0; i < 10; i++) {
            OsagoPolicyDto policyDTO = new OsagoPolicyDto();

            Company selectedCompany = insuranceCompanies.get(i);
            String companyName = insuranceCompanies.get(i).getName();

            policyDTO.setInsuranceCompany(companyName);

            BigDecimal insuranceCompanyCorrectionCoefficient = selectedCompany.getCoefficient();

            BigDecimal cost = ageDrivingExperienceCoefficient.getCoefficient()
                    .multiply(BigDecimal.valueOf(baseRateCoefficient.getMinRate()))
                    .multiply(driverNumberCoefficient.getCoefficient())
                    .multiply(BigDecimal.valueOf(enginePowerCoefficient.getCoefficient()))
                    .multiply(kbmCoefficient.getCoefficient())
                    .multiply(regionCoefficient.getVehicleCoefficient())
                    .multiply(seasonCoefficient.getCoefficient())
                    .multiply(insuranceCompanyCorrectionCoefficient);

            policyDTO.setCost(cost.setScale(2, RoundingMode.HALF_UP));
            policies.add(policyDTO);
        }

        return policies;
    }

    private List<Company> getAllInsuranceCompanies() {
        return companyRepository.findAll();
    }

}