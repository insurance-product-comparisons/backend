package ru.ya.insurance.controller.osago;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.dto.osago.FormFilterInitDto;
import ru.ya.insurance.dto.osago.OsagoPolicyDto;
import ru.ya.insurance.mapper.osago.*;
import ru.ya.insurance.service.osago.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/osago")
public class OsagoController {

    private final AgeDrivingExperienceCoefficientService ageDrivingExperienceCoefficientService;
    private final AgeDrivingExperienceCoefficientMapper ageDrivingExperienceCoefficientMapper;

    private final BaseRateCoefficientService baseRateCoefficientService;
    private final BaseRateMapper baseRateMapper;

    private final DriverNumberCoefficientService driverNumberCoefficientService;
    private final DriverNumberMapper driverNumberMapper;

    private final EnginePowerCoefficientService enginePowerCoefficientService;
    private final EnginePowerMapper enginePowerMapper;

    private final KbmCoefficientService kbmCoefficientService;
    private final KbmMapper kbmMapper;

    private final OsagoPolicyService osagoPolicyService;

    private final RegionCoefficientService regionCoefficientService;
    private final RegionMapper regionMapper;

    private final SeasonCoefficientService seasonCoefficientService;
    private final SeasonCoefficientMapper seasonCoefficientMapper;

    @GetMapping("/filter-init")
    public FormFilterInitDto getFilterInitDto() {

        FormFilterInitDto formFilterInitDto = new FormFilterInitDto();

        formFilterInitDto.setAgeDrivingExperienceCoefficientList(
                ageDrivingExperienceCoefficientMapper.ageDrivingExperienceCoefficientListToAgeDrivingExperienceCoefficientDtoList(
                        ageDrivingExperienceCoefficientService.getAgeDrivingExperienceCoefficientList()));

        formFilterInitDto.setBaseRateList(baseRateMapper.baseRateCoefficientListToBaseRateDtoList(
                baseRateCoefficientService.getBaseRateList()));

        formFilterInitDto.setDriverNumberCoefficientList(driverNumberMapper.driverNumberListToDriverNumberDtoList(
                driverNumberCoefficientService.getAllDriverNumberCoefficient()));

        formFilterInitDto.setEnginePowerList(enginePowerMapper.enginePowerCoefficientListToEnginePowerDtoList(
                enginePowerCoefficientService.getEnginePowerList()));

        formFilterInitDto.setKbmList(kbmMapper.kbmCoefficientListToKbmDtoList(kbmCoefficientService.getKbmDtoList()));

        formFilterInitDto.setRegionCoefficientList(regionMapper.toDtoList(regionCoefficientService.findAll()));

        formFilterInitDto.setSeasonCoefficientDtoList(seasonCoefficientMapper.seasonCoefficientListToKbmDtoList(
                seasonCoefficientService.getSeasonCoefficientDtoList()));

        return formFilterInitDto;
    }

    @GetMapping("/policies")
    public List<OsagoPolicyDto> getOsagoPolicies(
            @RequestParam(name = "ageRange") String ageRange,
            @RequestParam(name = "drivingExperienceRange") String drivingExperienceRange,
            @RequestParam(name = "transportType") String transportType,
            @RequestParam(name = "driverNumber") String driverNumber,
            @RequestParam(name = "enginePower") String enginePower,
            @RequestParam(name = "kbmClass") String kbmClass,
            @RequestParam(name = "regionName") String regionName,
            @RequestParam(name = "seasonPeriod") String seasonPeriod) {
        return osagoPolicyService.calculatePolicyCost(
                ageRange, drivingExperienceRange, transportType, driverNumber,
                enginePower, kbmClass, regionName, seasonPeriod);
    }

}