package ru.ya.insurance.service.osago;

import ru.ya.insurance.dto.osago.OsagoPolicyDto;

import java.util.List;

public interface OsagoPolicyService {
    List<OsagoPolicyDto> calculatePolicyCost(
            String ageRange, String drivingExperienceRange, String transportType, String driverNumber,
            String enginePower, String kbmClass, String regionName, String seasonPeriod);
}