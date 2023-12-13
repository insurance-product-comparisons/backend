package ru.ya.insurance.ageExperience.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.ageExperience.dto.DrivingExperienceDto;
import ru.ya.insurance.ageExperience.mapper.DrivingExperienceMapper;
import ru.ya.insurance.ageExperience.model.DrivingExperience;
import ru.ya.insurance.ageExperience.repository.DrivingExperienceRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DrivingExperienceService {

    private final DrivingExperienceRepository drivingExperienceRepository;
    private final DrivingExperienceMapper drivingExperienceMapper;

    public DrivingExperience getDrivingExperienceById(Long id) {
        return drivingExperienceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Коэффициент \"Стаж\" не найден"));
    }

    public List<DrivingExperienceDto> getDrivingExperienceDtoList() {
        return drivingExperienceRepository.findAll().stream()
                .map(drivingExperienceMapper::drivingExperienceToDto)
                .collect(Collectors.toList());
    }

}