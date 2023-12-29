package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import ru.ya.insurance.dto.osago.AgeDto;
import ru.ya.insurance.model.osago.Age;

import java.util.List;

@Mapper
public interface AgeMapper {

    List<AgeDto> ageListToAgeDtoList(List<Age> ageList);

}