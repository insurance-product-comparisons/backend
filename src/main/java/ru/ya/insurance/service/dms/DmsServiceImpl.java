package ru.ya.insurance.service.dms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.dto.dms.DmsRequestDto;
import ru.ya.insurance.dto.dms.DmsResponseDto;
import ru.ya.insurance.dto.dms.DmsShortDto;
import ru.ya.insurance.exception.NotFoundException;
import ru.ya.insurance.mapper.dms.DmsMapper;
import ru.ya.insurance.model.company.Company;
import ru.ya.insurance.model.dms.AgeDmsCoefficient;
import ru.ya.insurance.model.dms.Dms;
import ru.ya.insurance.model.region.RegionCoefficient;
import ru.ya.insurance.repository.company.CompanyRepository;
import ru.ya.insurance.repository.dms.AgeDmsCoefficientRepository;
import ru.ya.insurance.repository.dms.DmsRepository;
import ru.ya.insurance.repository.region.RegionCoefficientRepository;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
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

        List<DmsShortDto> result = companies.stream()
                .map(company -> {
                    DmsShortDto dmsShortDto = new DmsShortDto(company.getName());
                    dmsShortDto.setPrice(calculate(dmsRequestDto, company));
                    return dmsShortDto;
                })
                .sorted(Comparator.comparing(DmsShortDto::getPrice))
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public DmsResponseDto getDmsById(Long id, DmsRequestDto dmsRequestDto) {
        return null;
    }

    @Override
    public DmsResponseDto getDmsById(Long id, int age, int duration) {
        Dms dms = dmsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dms not found"));

        DmsResponseDto dmsResponseDto = DmsMapper.toDmsResponseDto(dms);

        dmsResponseDto.setPrice(calculate(dms, age, duration));

        return dmsResponseDto;
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


        BigDecimal cost = baseRate
                .multiply(regionCoefficient.getDmsCoefficient())
                .multiply(companyCoefficient)
                .multiply(BigDecimal.valueOf(duration))
                .multiply(ageDmsCoefficient.getCoefficient());
        return cost;
    }

    private BigDecimal calculate(Dms dms, int age, int duration) {
        AgeDmsCoefficient ageDmsCoefficient = ageDmsCoefficientRepository.findByAge(age)
                .orElseThrow(() -> new NotFoundException("Coefficient for the age " + age + " not found"));
        BigDecimal cost = dms.getBaseRate()
                .multiply(dms.getRegion().getDmsCoefficient())
                .multiply(dms.getCompany().getCoefficient())
                .multiply(BigDecimal.valueOf(duration))
                .multiply(ageDmsCoefficient.getCoefficient());
        return cost;
    }


}
