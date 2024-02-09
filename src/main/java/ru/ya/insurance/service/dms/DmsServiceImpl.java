package ru.ya.insurance.service.dms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.dto.dms.DmsRequestDto;
import ru.ya.insurance.dto.dms.DmsResponseDto;
import ru.ya.insurance.dto.dms.DmsShortDto;
import ru.ya.insurance.enums.InsuranceType;
import ru.ya.insurance.exception.NotFoundException;
import ru.ya.insurance.model.company.Company;
import ru.ya.insurance.model.dms.AgeDmsCoefficient;
import ru.ya.insurance.model.dms.Dms;
import ru.ya.insurance.model.insurance.Feature;
import ru.ya.insurance.model.insurance.Insurance;
import ru.ya.insurance.model.insurance.RequiredDocument;
import ru.ya.insurance.model.region.RegionCoefficient;
import ru.ya.insurance.repository.company.CompanyRepository;
import ru.ya.insurance.repository.dms.AgeDmsCoefficientRepository;
import ru.ya.insurance.repository.dms.DmsRepository;
import ru.ya.insurance.repository.region.RegionCoefficientRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DmsServiceImpl implements DmsService {

    private final DmsRepository dmsRepository;

    private final RegionCoefficientRepository regionCoefficientRepository;

    private final CompanyRepository companyRepository;

    private final AgeDmsCoefficientRepository ageDmsCoefficientRepository;

    @Override
    public List<DmsShortDto> getAllDms(DmsRequestDto dmsRequestDto) {

        List<Company> companies = companyRepository.findAll();

        return companies.stream()
                .map(company -> {
                    DmsShortDto dmsShortDto = new DmsShortDto(company.getName());
                    dmsShortDto.setPrice(calculate(dmsRequestDto, company));
                    return dmsShortDto;
                })
                .sorted(Comparator.comparing(DmsShortDto::getPrice))
                .collect(Collectors.toList());
    }


    @Override
    public DmsResponseDto getCard(BigDecimal price, String name, DmsRequestDto dmsRequestDto) {

        Company insuranceCompany = companyRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Insurance company not found"));

        BigDecimal newPrice = calculate(dmsRequestDto, insuranceCompany);

        DmsResponseDto result = new DmsResponseDto(
                insuranceCompany.getLogo(),
                insuranceCompany.getName(),
                insuranceCompany.getDescription(),
                newPrice
        );

        result.setDuration(dmsRequestDto.getDuration());

        List<Insurance> insuranceList = insuranceCompany.getInsurances();

        Insurance insurance = insuranceList.stream()
                .filter(insurance1 -> insurance1.getType().equals(InsuranceType.DMS))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Insurance not found"));

        Set<Feature> featureSet = insurance.getFeatures();
        List<String> features = new ArrayList<>();

        for (Feature feature : featureSet) {
            features.add(feature.getName());
        }
        result.setFeatures(features);

        Set<RequiredDocument> requiredDocuments = insurance.getRequiredDocuments();

        Set<String> requiredDocumentNames = requiredDocuments.stream()
                .map(RequiredDocument::getDocument)
                .collect(Collectors.toSet());

        result.setRequiredDocuments(requiredDocumentNames);

        return result;
    }

    private BigDecimal calculate(DmsRequestDto dmsRequestDto, Company company) {

        int age = dmsRequestDto.getAge();
        int duration = dmsRequestDto.getDuration();
        String region = dmsRequestDto.getRegion();

        AgeDmsCoefficient ageDmsCoefficient = ageDmsCoefficientRepository.findByAge(age)
                .orElseThrow(() -> new NotFoundException("Coefficient for the age " + age + " not found"));

        RegionCoefficient regionCoefficient = regionCoefficientRepository.findByRegion(region)
                .orElseThrow(() -> new NotFoundException("Coefficient for the region " + region + " not found"));

        BigDecimal companyCoefficient = company.getCoefficient();

        BigDecimal baseRate = BigDecimal.valueOf(5000);


        return baseRate
                .multiply(regionCoefficient.getDmsCoefficient())
                .multiply(companyCoefficient)
                .multiply(BigDecimal.valueOf(duration))
                .multiply(ageDmsCoefficient.getCoefficient());
    }

    private BigDecimal calculate(Dms dms, int age, int duration) {

        AgeDmsCoefficient ageDmsCoefficient = ageDmsCoefficientRepository.findByAge(age)
                .orElseThrow(() -> new NotFoundException("Coefficient for the age " + age + " not found"));

        return dms.getBaseRate()
                .multiply(dms.getRegion().getDmsCoefficient())
                .multiply(dms.getCompany().getCoefficient())
                .multiply(BigDecimal.valueOf(duration))
                .multiply(ageDmsCoefficient.getCoefficient());
    }


}
