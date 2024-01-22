package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import ru.ya.insurance.dto.osago.AgeDrivingExperienceCoefficientDto;
import ru.ya.insurance.model.osago.AgeDrivingExperienceCoefficient;

import java.util.List;

@Mapper
public interface AgeDrivingExperienceCoefficientMapper {

    AgeDrivingExperienceCoefficientDto ageDrivingExperienceCoefficientToAgeDrivingExperienceCoefficientDto(
            AgeDrivingExperienceCoefficient ageDrivingExperienceCoefficient);

    List<AgeDrivingExperienceCoefficientDto> ageDrivingExperienceCoefficientListToAgeDrivingExperienceCoefficientDtoList(
            List<AgeDrivingExperienceCoefficient> ageDrivingExperienceCoefficientList);

}