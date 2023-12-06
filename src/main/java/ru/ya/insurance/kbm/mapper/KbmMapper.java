package ru.ya.insurance.kbm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.ya.insurance.kbm.dto.KbmDto;
import ru.ya.insurance.kbm.model.Kbm;

@Mapper(componentModel = "spring")
public interface KbmMapper {

    @Mapping(source = "kbmClass", target = "kbmName")
    KbmDto kbmToKbmDto(Kbm kbm);

    @Mapping(source = "kbmName", target = "kbmClass")
    Kbm kbmDtoToKbm(KbmDto kbmDto);

}