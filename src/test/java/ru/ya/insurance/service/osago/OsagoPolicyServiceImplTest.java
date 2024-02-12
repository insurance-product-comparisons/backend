package ru.ya.insurance.service.osago;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.ya.insurance.dto.osago.OsagoPolicyDto;
import ru.ya.insurance.exception.NotFoundException;
import ru.ya.insurance.model.company.Company;
import ru.ya.insurance.model.osago.*;
import ru.ya.insurance.model.region.RegionCoefficient;
import ru.ya.insurance.repository.company.CompanyRepository;
import ru.ya.insurance.repository.osago.*;
import ru.ya.insurance.repository.region.RegionCoefficientRepository;
import ru.ya.insurance.service.osago.impl.OsagoPolicyServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OsagoPolicyServiceImplTest {

    @Mock
    private AgeDrivingExperienceCoefficientRepository ageDrivingExperienceCoefficientRepository;

    @Mock
    private BaseRateCoefficientRepository baseRateCoefficientRepository;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private DriverNumberCoefficientRepository driverNumberCoefficientRepository;

    @Mock
    private EnginePowerCoefficientRepository enginePowerCoefficientRepository;

    @Mock
    private KbmCoefficientRepository kbmCoefficientRepository;

    @Mock
    private RegionCoefficientRepository regionCoefficientRepository;

    @Mock
    private SeasonCoefficientRepository seasonCoefficientRepository;

    @InjectMocks
    private OsagoPolicyServiceImpl osagoPolicyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculatePolicyCost_ReturnsCorrectPolicyDto() {
        AgeDrivingExperienceCoefficient ageDrivingExperienceCoefficient = new AgeDrivingExperienceCoefficient();
        ageDrivingExperienceCoefficient.setCoefficient(BigDecimal.valueOf(4.5));
        when(ageDrivingExperienceCoefficientRepository.findByAgeRangeAndDrivingExperienceRange("16-21", "1"))
                .thenReturn(Optional.of(ageDrivingExperienceCoefficient));

        BaseRateCoefficient baseRateCoefficient = new BaseRateCoefficient();
        baseRateCoefficient.setTransportType("Легковые автомобили физ. лиц (\"В\", \"ВЕ\")");
        baseRateCoefficient.setMinRate(1000L);
        when(baseRateCoefficientRepository.findByTransportType("Легковые автомобили физ. лиц (\"В\", \"ВЕ\")"))
                .thenReturn(Optional.of(baseRateCoefficient));

        DriverNumberCoefficient driverNumberCoefficient = new DriverNumberCoefficient();
        driverNumberCoefficient.setName("1 и более");
        driverNumberCoefficient.setCoefficient(BigDecimal.valueOf(1.0));
        when(driverNumberCoefficientRepository.findByName("1 и более"))
                .thenReturn(Optional.of(driverNumberCoefficient));

        EnginePowerCoefficient enginePowerCoefficient = new EnginePowerCoefficient();
        enginePowerCoefficient.setPower("121-150 л.с");
        enginePowerCoefficient.setCoefficient(1.2);
        when(enginePowerCoefficientRepository.findByPower("121-150 л.с"))
                .thenReturn(Optional.of(enginePowerCoefficient));

        KbmCoefficient kbmCoefficient = new KbmCoefficient(BigDecimal.valueOf(1.0));
        when(kbmCoefficientRepository.findByKbmClass("12")).thenReturn(Optional.of(kbmCoefficient));

        RegionCoefficient regionCoefficient = new RegionCoefficient();
        regionCoefficient.setRegion("Москва");
        regionCoefficient.setVehicleCoefficient(BigDecimal.valueOf(1.0));
        when(regionCoefficientRepository.findByRegion("Москва")).thenReturn(Optional.of(regionCoefficient));

        SeasonCoefficient seasonCoefficient = new SeasonCoefficient(BigDecimal.valueOf(1.0));
        when(seasonCoefficientRepository.findByUsagePeriod("10-12")).thenReturn(Optional.of(seasonCoefficient));

        List<Company> companies = new ArrayList<>();
        Company company = new Company();
        company.setName("СберСтрахование");
        company.setCoefficient(BigDecimal.valueOf(1.0));
        companies.add(company);
        when(companyRepository.findAll()).thenReturn(companies);

        List<OsagoPolicyDto> policies = osagoPolicyService
                .calculatePolicyCost("16-21", "1", "Легковые автомобили физ. лиц (\"В\", \"ВЕ\")",
                        "1 и более", "121-150 л.с", "12", "Москва", "10-12");

        assertNotNull(policies);
        assertEquals(1, policies.size());
        OsagoPolicyDto policyDto = policies.get(0);
        assertEquals("СберСтрахование", policyDto.getInsuranceCompany());
        assertEquals(0, BigDecimal.valueOf(5400.00).compareTo(policyDto.getCost()));
    }

    @Test
    void testCalculatePolicyCost_NoAgeDrivingExperienceCoefficient_ThrowsNotFoundException() {
        when(ageDrivingExperienceCoefficientRepository.findByAgeRangeAndDrivingExperienceRange("16-21", "6-10"))
                .thenReturn(Optional.empty());

        assertThrows(NotFoundException.class,
                () -> osagoPolicyService.calculatePolicyCost("16-21", "1",
                        "Легковые автомобили физ. лиц (\"В\", \"ВЕ\")", "1 и более",
                        "121-150 л.с", "12", "Москва", "10-12"));
    }

}