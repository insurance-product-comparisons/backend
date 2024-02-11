package ru.ya.insurance.service.dms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ya.insurance.dto.dms.DmsRequestDto;
import ru.ya.insurance.dto.dms.DmsResponseDto;
import ru.ya.insurance.dto.dms.DmsShortDto;
import ru.ya.insurance.enums.InsuranceType;
import ru.ya.insurance.model.company.Company;
import ru.ya.insurance.model.dms.AgeDmsCoefficient;
import ru.ya.insurance.model.dms.DmsBaseRate;
import ru.ya.insurance.model.insurance.Feature;
import ru.ya.insurance.model.insurance.Insurance;
import ru.ya.insurance.model.insurance.RequiredDocument;
import ru.ya.insurance.model.region.RegionCoefficient;
import ru.ya.insurance.repository.company.CompanyRepository;
import ru.ya.insurance.repository.dms.AgeDmsCoefficientRepository;
import ru.ya.insurance.repository.dms.DmsBaseRateRepository;
import ru.ya.insurance.repository.region.RegionCoefficientRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DmsServiceImplTest {

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private DmsBaseRateRepository dmsBaseRateRepository;

    @Mock
    private AgeDmsCoefficientRepository ageDmsCoefficientRepository;

    @Mock
    private RegionCoefficientRepository regionCoefficientRepository;

    @InjectMocks
    private DmsServiceImpl dmsService;

    @Test
    void testGetAllDms() {

        DmsRequestDto dmsRequestDto = new DmsRequestDto(1, 12, "Уфа");

        AgeDmsCoefficient ageDmsCoefficient = new AgeDmsCoefficient(1L, 1, BigDecimal.valueOf(1.1));
        RegionCoefficient regionDmsCoefficient = new RegionCoefficient(
                1L, dmsRequestDto.getRegion(), BigDecimal.valueOf(1.1));
        List<Company> companies = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            companies.add(new Company(
                    1L, "Name", "Description", 1.2,
                    "logo", new ArrayList<>(), new HashSet<>(), BigDecimal.valueOf(2.5)));
        }

        DmsBaseRate dmsBaseRate = new DmsBaseRate(1L, BigDecimal.valueOf(1000));

        when(companyRepository.findAll())
                .thenReturn(companies);
        when(dmsBaseRateRepository.getDmsBaseRate())
                .thenReturn(Optional.of(dmsBaseRate));
        when(ageDmsCoefficientRepository.findByAge(dmsRequestDto.getAge()))
                .thenReturn(Optional.of(ageDmsCoefficient));
        when(regionCoefficientRepository.findByRegion(dmsRequestDto.getRegion()))
                .thenReturn(Optional.of(regionDmsCoefficient));

        List<DmsShortDto> result = dmsService.getAllDms(dmsRequestDto);

        assertEquals("Name", result.get(0).getInsuranceCompany());
        assertEquals(10, result.size());

        verify(companyRepository, times(1)).findAll();
    }

    @Test
    void testGetCard() {

        DmsRequestDto dmsRequestDto = new DmsRequestDto(1, 12, "Уфа");

        AgeDmsCoefficient ageDmsCoefficient = new AgeDmsCoefficient(1L, 1, BigDecimal.valueOf(1.1));

        RegionCoefficient regionDmsCoefficient = new RegionCoefficient(
                1L, dmsRequestDto.getRegion(), BigDecimal.valueOf(1.1));

        BigDecimal price = BigDecimal.valueOf(36300).setScale(2, RoundingMode.HALF_UP);

        Company company = new Company(1L, "Name", "Description", 1.2, "logo",
                Collections.singletonList(
                        new Insurance(InsuranceType.DMS,
                                new HashSet<>(List.of(new Feature("Feature"))),
                                new HashSet<>(List.of((new RequiredDocument("Document")))))),
                new HashSet<>(),
                BigDecimal.valueOf(2.5));

        DmsBaseRate dmsBaseRate = new DmsBaseRate(1L, BigDecimal.valueOf(1000));

        when(dmsBaseRateRepository.getDmsBaseRate())
                .thenReturn(Optional.of(dmsBaseRate));
        when(companyRepository.findByName(company.getName()))
                .thenReturn(Optional.of(company));
        when(ageDmsCoefficientRepository.findByAge(dmsRequestDto.getAge()))
                .thenReturn(Optional.of(ageDmsCoefficient));
        when(regionCoefficientRepository.findByRegion(dmsRequestDto.getRegion()))
                .thenReturn(Optional.of(regionDmsCoefficient));
        when(regionCoefficientRepository.findByRegion(dmsRequestDto.getRegion()))
                .thenReturn(Optional.of(regionDmsCoefficient));

        DmsResponseDto result = dmsService.getCard(price, company.getName(), dmsRequestDto);

        assertEquals("Name", result.getCompanyName());
        assertEquals(1, result.getFeatures().size());
        assertEquals("logo", result.getCompanyLogo());
        assertEquals(price, result.getPrice());

        verify(companyRepository, times(1)).findByName(company.getName());
        verify(ageDmsCoefficientRepository, times(1)).findByAge(dmsRequestDto.getAge());
        verify(regionCoefficientRepository, times(1)).findByRegion(dmsRequestDto.getRegion());
    }
}