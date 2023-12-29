package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import ru.ya.insurance.dto.osago.DrivingExperienceDto;
import ru.ya.insurance.model.osago.DrivingExperience;

import java.util.List;

@Mapper
public interface DrivingExperienceMapper {

    DrivingExperienceDto drivingExperienceToDrivingExperienceDto(DrivingExperience drivingExperience);

    List<DrivingExperienceDto> drivingExperienceListToDrivingExperienceDtoList(List<DrivingExperience> drivingExperienceList);

}