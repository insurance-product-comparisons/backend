package ru.ya.insurance.service.dms;

import ru.ya.insurance.dto.dms.DmsRequestDto;
import ru.ya.insurance.dto.dms.DmsResponseDto;

import java.util.List;

public interface DmsService {

    List<DmsResponseDto> getAllDms(DmsRequestDto dmsRequestDto);
}
