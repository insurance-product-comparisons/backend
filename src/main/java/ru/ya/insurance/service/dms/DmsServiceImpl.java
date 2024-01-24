package ru.ya.insurance.service.dms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.dto.dms.DmsRequestDto;
import ru.ya.insurance.dto.dms.DmsResponseDto;
import ru.ya.insurance.mapper.dms.DmsMapper;
import ru.ya.insurance.model.dms.Dms;
import ru.ya.insurance.repository.dms.DmsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DmsServiceImpl implements DmsService {

    private final DmsRepository dmsRepository;

    @Override
    public List<DmsResponseDto> getAllDms(DmsRequestDto dmsRequestDto) {
        int age = dmsRequestDto.getAge();
        int insuranceTerm = dmsRequestDto.getInsuranceTerm();
        String region = dmsRequestDto.getRegion();

        List<Dms> dmsList = dmsRepository.findAllByAgeAndInsuranceTermAndRegion(age, insuranceTerm, region);

        return DmsMapper.toDmsResponseDto(dmsList);
    }
}
