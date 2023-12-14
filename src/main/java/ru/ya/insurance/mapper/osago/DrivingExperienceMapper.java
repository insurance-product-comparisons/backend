package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.ya.insurance.dto.osago.DrivingExperienceDto;
import ru.ya.insurance.model.osago.DrivingExperience;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DrivingExperienceMapper {

    DrivingExperienceDto drivingExperienceToDrivingExperienceDto(DrivingExperience drivingExperience);

    List<DrivingExperienceDto> drivingExperienceListToDrivingExperienceDtoList(List<DrivingExperience> drivingExperienceList);

}