package ru.ya.insurance.kbm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.ya.insurance.kbm.dto.KbmDto;
import ru.ya.insurance.kbm.model.Kbm;

@Mapper
public interface KbmMapper {

    KbmMapper INSTANCE = Mappers.getMapper(KbmMapper.class);

    @Mapping(source = "kbmClass", target = "kbmName")
    KbmDto kbmToKbmDto(Kbm kbm);

    @Mapping(source = "kbmName", target = "kbmClass")
    Kbm kbmDtoToKbm(KbmDto kbmDto);

}