package ru.ya.insurance.ageExperience.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.ya.insurance.ageExperience.dto.DrivingExperienceDto;
import ru.ya.insurance.ageExperience.model.DrivingExperience;

@Mapper(componentModel = "spring")
public interface DrivingExperienceMapper {

    @Mapping(source = "name", target = "name")
    DrivingExperienceDto drivingExperienceToDto(DrivingExperience drivingExperience);

}