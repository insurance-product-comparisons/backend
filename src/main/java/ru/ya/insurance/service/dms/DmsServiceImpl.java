package ru.ya.insurance.service.dms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.dto.dms.DmsRequestDto;
import ru.ya.insurance.dto.dms.DmsResponseDto;
import ru.ya.insurance.dto.dms.DmsShortDto;
import ru.ya.insurance.exception.NotFoundException;
import ru.ya.insurance.mapper.dms.DmsMapper;
import ru.ya.insurance.model.dms.AgeDmsCoefficient;
import ru.ya.insurance.model.dms.Dms;
import ru.ya.insurance.repository.dms.AgeDmsCoefficientRepository;
import ru.ya.insurance.repository.dms.DmsRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DmsServiceImpl implements DmsService {

    private final DmsRepository dmsRepository;

    private final AgeDmsCoefficientRepository ageDmsCoefficientRepository;

    @Override
    public List<DmsShortDto> getAllDms(DmsRequestDto dmsRequestDto) {
        int age = dmsRequestDto.getAge();
        int duration = dmsRequestDto.getDuration();
        String region = dmsRequestDto.getRegion();

        List<Dms> dmsList = dmsRepository.findAllDmsByRegionOrderByBaseRate(region);

        List<DmsShortDto> result = dmsList.stream()
                .map(dms -> {
                    BigDecimal cost = calculate(dms, age, duration);
                    return DmsMapper.toDmsShortDto(dms, cost);
                })
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public DmsResponseDto getDmsById(Long id, DmsRequestDto dmsRequestDto) {
        Dms dms = dmsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dms not found"));

        DmsResponseDto dmsResponseDto = DmsMapper.toDmsResponseDto(dms);

        dmsResponseDto.setPrice(calculate(dms, dmsRequestDto.getAge(), dmsRequestDto.getDuration()));

        return dmsResponseDto;
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
