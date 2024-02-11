package ru.ya.insurance.service.dms;

import ru.ya.insurance.dto.dms.DmsRequestDto;
import ru.ya.insurance.dto.dms.DmsResponseDto;
import ru.ya.insurance.dto.dms.DmsShortDto;

import java.math.BigDecimal;
import java.util.List;

public interface DmsService {

    List<DmsShortDto> getAllDms(DmsRequestDto dmsRequestDto);

    DmsResponseDto getCard(BigDecimal price, String name, DmsRequestDto dmsRequestDto);
}
