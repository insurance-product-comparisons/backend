package ru.ya.insurance.controller.osago;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.dto.osago.FormFilterInitDto;
import ru.ya.insurance.mapper.osago.AgeMapper;
import ru.ya.insurance.mapper.osago.BaseRateMapper;
import ru.ya.insurance.mapper.osago.DriverNumberMapper;
import ru.ya.insurance.mapper.osago.DrivingExperienceMapper;
import ru.ya.insurance.mapper.osago.EnginePowerMapper;
import ru.ya.insurance.mapper.osago.KbmMapper;
import ru.ya.insurance.service.osago.AgeService;
import ru.ya.insurance.service.osago.BaseRateCoefficientService;
import ru.ya.insurance.service.osago.DriverNumberCoefficientService;
import ru.ya.insurance.service.osago.DrivingExperienceService;
import ru.ya.insurance.service.osago.EnginePowerCoefficientService;
import ru.ya.insurance.service.osago.RegionCoefficientService;
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

    @GetMapping
    @RequestMapping("/filter-init")
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
