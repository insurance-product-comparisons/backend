package ru.ya.insurance.mapper.dms;

import lombok.experimental.UtilityClass;
import ru.ya.insurance.dto.dms.DmsResponseDto;
import ru.ya.insurance.dto.dms.DmsShortDto;
import ru.ya.insurance.model.dms.Dms;

import java.math.BigDecimal;

@UtilityClass
public class DmsMapper {

    public static DmsResponseDto toDmsResponseDto(Dms dms) {
        return new DmsResponseDto(
                dms.getId(),
                dms.getCompany().getLogo(),
                dms.getCompany().getName(),
                dms.getCompany().getDescription(),
                dms.getBaseRate()
        );
    }

    public static DmsShortDto toDmsShortDto(Dms dms, BigDecimal cost) {
        return new DmsShortDto(dms.getId(), dms.getCompany().getName(), cost);

    }
}
