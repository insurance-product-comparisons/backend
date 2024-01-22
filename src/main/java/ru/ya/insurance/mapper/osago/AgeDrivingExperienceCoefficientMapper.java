package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import ru.ya.insurance.dto.osago.AgeDrivingExperienceCoefficientDto;
import ru.ya.insurance.model.osago.AgeDrivingExperienceCoefficient;

import java.util.List;

@Mapper
public interface AgeDrivingExperienceCoefficientMapper {

    AgeDrivingExperienceCoefficientDto AgeDrivingExperienceCoefficientToAgeDrivingExperienceCoefficientDto(
            AgeDrivingExperienceCoefficient ageDrivingExperienceCoefficient);

    List<AgeDrivingExperienceCoefficientDto> AgeDrivingExperienceCoefficientListToAgeDrivingExperienceCoefficientDtoList(
            List<AgeDrivingExperienceCoefficient> ageDrivingExperienceCoefficientList);

}