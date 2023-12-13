package ru.ya.insurance.ageExperience.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.ya.insurance.ageExperience.dto.AgeDto;
import ru.ya.insurance.ageExperience.model.Age;

@Mapper(componentModel = "spring")
public interface AgeMapper {

    @Mapping(source = "name", target = "name")
    AgeDto ageToDto(Age age);

}