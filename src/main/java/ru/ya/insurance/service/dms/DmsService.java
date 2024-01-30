package ru.ya.insurance.service.dms;

import ru.ya.insurance.dto.dms.DmsRequestDto;
import ru.ya.insurance.dto.dms.DmsResponseDto;
import ru.ya.insurance.dto.dms.DmsShortDto;

import java.util.List;

public interface DmsService {

    List<DmsShortDto> getAllDms(DmsRequestDto dmsRequestDto);

    DmsResponseDto getDmsById(Long id, DmsRequestDto dmsRequestDto);
}
