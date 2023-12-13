package ru.ya.insurance.ageExperience.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.ageExperience.dto.AgeDto;
import ru.ya.insurance.ageExperience.dto.AgeExperienceCoefficientDto;
import ru.ya.insurance.ageExperience.dto.DrivingExperienceDto;
import ru.ya.insurance.ageExperience.service.AgeExperienceCoefficientService;
import ru.ya.insurance.ageExperience.service.AgeService;
import ru.ya.insurance.ageExperience.service.DrivingExperienceService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping
public class AgeExperienceController {

    private final AgeService ageService;
    private final AgeExperienceCoefficientService ageExperienceCoefficientService;
    private final DrivingExperienceService drivingExperienceService;

    @GetMapping("/age")
    public List<AgeDto> getAgeDtoList() {
        return ageService.getAgeDtoList();
    }

    @GetMapping("/driving-experience")
    public List<DrivingExperienceDto> getDrivingExperienceDtoList() {
        return drivingExperienceService.getDrivingExperienceDtoList();
    }

    @GetMapping("/age-experience-coefficient")
    public AgeExperienceCoefficientDto getCoefficient(@RequestParam Long ageId,
                                                      @RequestParam Long experienceId) {
        BigDecimal coefficient = ageExperienceCoefficientService.getCoefficientByAgeAndExperience(ageId, experienceId);
        AgeExperienceCoefficientDto dto = new AgeExperienceCoefficientDto();
        dto.setCoefficient(coefficient);
        return dto;
    }

}