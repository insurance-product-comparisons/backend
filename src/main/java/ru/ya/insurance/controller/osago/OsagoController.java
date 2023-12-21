package ru.ya.insurance.controller.osago;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.dto.osago.FormFilterInitDto;
import ru.ya.insurance.mapper.osago.*;
import ru.ya.insurance.service.osago.*;
import ru.ya.insurance.service.osago.impl.KbmCoefficientServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/osago")
public class OsagoController {

    private final AgeService ageService;
    private final AgeMapper ageMapper;

    private final DrivingExperienceService drivingExperienceService;
    private final DrivingExperienceMapper drivingExperienceMapper;

    private final BaseRateCoefficientService baseRateCoefficientService;
    private final BaseRateMapper baseRateMapper;

    private final DriverNumberCoefficientService driverNumberCoefficientService;
    private final DriverNumberMapper driverNumberMapper;

    private final EnginePowerCoefficientService enginePowerCoefficientService;
    private final EnginePowerMapper enginePowerMapper;

    private final KbmCoefficientServiceImpl kbmServiceImpl;
    private final KbmMapper kbmMapper;

    private final RegionCoefficientService regionCoefficientService;

    @GetMapping("/filter-init")
    public FormFilterInitDto getFilterInitDto() {

        FormFilterInitDto formFilterInitDto = new FormFilterInitDto();

        formFilterInitDto.setAgeList(ageMapper.ageListToAgeDtoList(ageService.getAgeList()));

        formFilterInitDto.setDrivingExperienceList(drivingExperienceMapper.drivingExperienceListToDrivingExperienceDtoList(drivingExperienceService.getDrivingExperienceList()));

        formFilterInitDto.setBaseRateList(baseRateMapper.baseRateCoefficientListToBaseRateDtoList(baseRateCoefficientService.getBaseRateList()));

        formFilterInitDto.setDriverNumberCoefficientList(driverNumberMapper.driverNumberListToDriverNumberDtoList(driverNumberCoefficientService.getAllDriverNumberCoefficient()));

        formFilterInitDto.setEnginePowerList(enginePowerMapper.enginePowerCoefficientListToEnginePowerDtoList(enginePowerCoefficientService.getEnginePowerList()));

        formFilterInitDto.setKbmList(kbmMapper.kbmCoefficientListToKbmDtoList(kbmServiceImpl.getKbmDtoList()));

        formFilterInitDto.setRegionCoefficientList(regionCoefficientService.findAll());

        return formFilterInitDto;
    }
}
