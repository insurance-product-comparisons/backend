package ru.ya.insurance.service.osago;

import ru.ya.insurance.model.osago.DrivingExperience;

import java.util.List;

public interface DrivingExperienceService {
    DrivingExperience getDrivingExperienceById(Long id);

    List<DrivingExperience> getDrivingExperienceList();
}
