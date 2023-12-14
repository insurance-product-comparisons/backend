package ru.ya.insurance.service.osago.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.model.osago.DrivingExperience;
import ru.ya.insurance.repository.osago.DrivingExperienceRepository;
import ru.ya.insurance.service.osago.DrivingExperienceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrivingExperienceServiceImpl implements DrivingExperienceService {

    private final DrivingExperienceRepository drivingExperienceRepository;

    @Override
    public DrivingExperience getDrivingExperienceById(Long id) {
        return drivingExperienceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Коэффициент \"Стаж\" не найден"));
    }

    @Override
    public List<DrivingExperience> getDrivingExperienceList() {
        return drivingExperienceRepository.findAll();
    }

}