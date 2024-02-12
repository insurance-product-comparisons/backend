package ru.ya.insurance.service.kasko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
import ru.ya.insurance.service.kasko.impl.KaskoPolicyServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class KaskoPolicyServiceImplTest {

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private KaskoCarModelRepository kaskoCarModelRepository;

    @Mock
    private KaskoDrivingExperienceCoefficientRepository kaskoDrivingExperienceCoefficientRepository;

    @Mock
    private KaskoManufactureYearCoefficientRepository kaskoManufactureYearCoefficientRepository;

    @InjectMocks
    private KaskoPolicyServiceImpl kaskoPolicyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculatePolicyCost_ReturnsCorrectPolicyDto() {
        KaskoCarModel kaskoCarModel = new KaskoCarModel(BigDecimal.valueOf(1.2));
        KaskoDrivingExperienceCoefficient kaskoDrivingExperienceCoefficient = new KaskoDrivingExperienceCoefficient();
        kaskoDrivingExperienceCoefficient.setCoefficient(BigDecimal.valueOf(4.5));
        KaskoManufactureYearCoefficient kaskoManufactureYearCoefficient = new KaskoManufactureYearCoefficient();
        kaskoManufactureYearCoefficient.setCoefficient(BigDecimal.valueOf(3.0));
        when(kaskoCarModelRepository.findByBrandAndModel("BMW", "3 Series")).thenReturn(Optional.of(kaskoCarModel));
        when(kaskoDrivingExperienceCoefficientRepository.findByDrivingExperienceRange("0-5"))
                .thenReturn(Optional.of(kaskoDrivingExperienceCoefficient));
        when(kaskoManufactureYearCoefficientRepository.findByManufactureYear(2024))
                .thenReturn(Optional.of(kaskoManufactureYearCoefficient));

        Company company = new Company();
        company.setName("Согласие");
        company.setCoefficient(BigDecimal.valueOf(1.15));
        List<Company> companies = new ArrayList<>();
        companies.add(company);
        when(companyRepository.findAll()).thenReturn(companies);

        List<KaskoPolicyDto> policies = kaskoPolicyService
                .calculatePolicyCost("BMW", "3 Series", 2024, "0-5");

        assertNotNull(policies);
        assertEquals(1, policies.size());
        KaskoPolicyDto policyDto = policies.get(0);
        assertEquals("Согласие", policyDto.getInsuranceCompany());
        assertEquals(0, BigDecimal.valueOf(55890.00).compareTo(policyDto.getCost()));
    }

    @Test
    void testCalculatePolicyCost_NoCarModel_ThrowsNotFoundException() {
        KaskoManufactureYearCoefficient kaskoManufactureYearCoefficient = new KaskoManufactureYearCoefficient();
        kaskoManufactureYearCoefficient.setCoefficient(BigDecimal.valueOf(3.0));
        KaskoDrivingExperienceCoefficient kaskoDrivingExperienceCoefficient = new KaskoDrivingExperienceCoefficient();
        kaskoDrivingExperienceCoefficient.setCoefficient(BigDecimal.valueOf(1.0));
        when(kaskoCarModelRepository.findByBrandAndModel("BMW", "X3")).thenReturn(Optional.empty());
        when(kaskoDrivingExperienceCoefficientRepository.findByDrivingExperienceRange("6-10"))
                .thenReturn(Optional.of(kaskoDrivingExperienceCoefficient));
        when(kaskoManufactureYearCoefficientRepository.findByManufactureYear(2024))
                .thenReturn(Optional.of(kaskoManufactureYearCoefficient));

        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> kaskoPolicyService.calculatePolicyCost("BMW", "Tiguan", 2024, "6-10"));
        assertEquals("Коэффициент KaskoCarModel не найден", exception.getMessage());
    }

    @Test
    void testCalculatePolicyCost_CorrectPriceCalculation() {
        KaskoCarModel kaskoCarModel = new KaskoCarModel(BigDecimal.valueOf(1.5));
        KaskoDrivingExperienceCoefficient kaskoDrivingExperienceCoefficient = new KaskoDrivingExperienceCoefficient();
        kaskoDrivingExperienceCoefficient.setCoefficient(BigDecimal.valueOf(0.8));
        KaskoManufactureYearCoefficient kaskoManufactureYearCoefficient = new KaskoManufactureYearCoefficient();
        kaskoManufactureYearCoefficient.setCoefficient(BigDecimal.valueOf(0.9));
        Company company = new Company();
        company.setCoefficient(BigDecimal.valueOf(1.1));

        when(kaskoCarModelRepository.findByBrandAndModel("Toyota", "Corolla"))
                .thenReturn(Optional.of(kaskoCarModel));
        when(kaskoDrivingExperienceCoefficientRepository.findByDrivingExperienceRange("6-10"))
                .thenReturn(Optional.of(kaskoDrivingExperienceCoefficient));
        when(kaskoManufactureYearCoefficientRepository.findByManufactureYear(2020))
                .thenReturn(Optional.of(kaskoManufactureYearCoefficient));
        when(companyRepository.findAll()).thenReturn(List.of(company));

        List<KaskoPolicyDto> policies = kaskoPolicyService
                .calculatePolicyCost("Toyota", "Corolla", 2020, "6-10");

        assertNotNull(policies);
        assertEquals(1, policies.size());
        KaskoPolicyDto policyDto = policies.get(0);
        assertEquals(0, BigDecimal.valueOf(3564.0).compareTo(policyDto.getCost()));
    }

    @Test
    void testCalculatePolicyCost_ReturnsEmptyPoliciesList() {
        when(kaskoCarModelRepository.findByBrandAndModel("Toyota", "Corolla")).thenReturn(Optional.of(new KaskoCarModel()));
        when(kaskoDrivingExperienceCoefficientRepository.findByDrivingExperienceRange("0-5"))
                .thenReturn(Optional.of(new KaskoDrivingExperienceCoefficient()));
        when(kaskoManufactureYearCoefficientRepository.findByManufactureYear(2020))
                .thenReturn(Optional.of(new KaskoManufactureYearCoefficient()));
        when(companyRepository.findAll()).thenReturn(new ArrayList<>());

        List<KaskoPolicyDto> policies = kaskoPolicyService
                .calculatePolicyCost("Toyota", "Corolla", 2020, "0-5");

        assertNotNull(policies);
        assertTrue(policies.isEmpty());
    }

}