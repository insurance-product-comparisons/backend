package ru.ya.insurance.service.kasko;

import ru.ya.insurance.dto.kasko.KaskoPolicyDto;

import java.util.List;

public interface KaskoPolicyService {

    List<KaskoPolicyDto> calculatePolicyCost(String brand, String model, int manufactureYear, String drivingExperience);

}