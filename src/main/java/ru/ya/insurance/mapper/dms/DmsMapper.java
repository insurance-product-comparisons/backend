package ru.ya.insurance.mapper.dms;

import lombok.experimental.UtilityClass;
import ru.ya.insurance.dto.dms.DmsRequestDto;
import ru.ya.insurance.dto.dms.DmsResponseDto;
import ru.ya.insurance.model.dms.Dms;
import java.util.Collections;
import java.util.List;

@UtilityClass
public class DmsMapper {

    public static List<DmsResponseDto> toDmsResponseDto(List<Dms> dmsList) {
        return Collections.EMPTY_LIST;
    }


    public static Dms toDms(DmsRequestDto dmsRequestDto) {
        return new Dms();
    }
}
