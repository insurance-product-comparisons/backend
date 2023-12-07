package ru.ya.insurance.ageExperience.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.ya.insurance.ageExperience.dto.AgeExperienceCoefficientDto;
import ru.ya.insurance.ageExperience.model.AgeExperienceCoefficient;

@Mapper(componentModel = "spring")
public interface AgeExperienceCoefficientMapper {

    @Mapping(source = "coefficient", target = "coefficient")
    AgeExperienceCoefficientDto ageExperienceCoefficientToDto(AgeExperienceCoefficient coefficient);

}