package ru.ya.insurance.dto.osago;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormFilterInitDto {
    private List<AgeDto> ageList;
    private List<DrivingExperienceDto> drivingExperienceList;
    private List<BaseRateDto> baseRateList;
    private List<EnginePowerDto> enginePowerList;
    private List<DriverNumberDto> driverNumberCoefficientList;
    private List<KbmDto> kbmList;
    private List<RegionDto> regionCoefficientList;
}
