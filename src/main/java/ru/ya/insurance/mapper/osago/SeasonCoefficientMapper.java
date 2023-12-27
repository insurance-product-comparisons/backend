package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import ru.ya.insurance.dto.osago.SeasonCoefficientDto;
import ru.ya.insurance.model.osago.SeasonCoefficient;

import java.util.List;

@Mapper
public interface SeasonCoefficientMapper {

    SeasonCoefficientDto seasonCoefficientToKbmDto(SeasonCoefficient seasonCoefficient);

    List<SeasonCoefficientDto> seasonCoefficientListToKbmDtoList(List<SeasonCoefficient> seasonCoefficientList);

}