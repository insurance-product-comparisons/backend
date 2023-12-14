package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.ya.insurance.dto.osago.KbmDto;
import ru.ya.insurance.model.osago.KbmCoefficient;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface KbmMapper {

    @Mapping(source = "kbmClass", target = "kbmName")
    KbmDto kbmCoefficientToKbmDto(KbmCoefficient kbmCoefficient);

    List<KbmDto> kbmCoefficientListToKbmDtoList(List<KbmCoefficient> kbmCoefficientList);

}