package ru.ya.insurance.controller.kasko;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.dto.kasko.KaskoCarModelDto;
import ru.ya.insurance.dto.kasko.KaskoPolicyDto;
import ru.ya.insurance.mapper.kasko.KaskoCarModelMapper;
import ru.ya.insurance.model.kasko.KaskoCarModel;
import ru.ya.insurance.service.kasko.KaskoCarModelService;
import ru.ya.insurance.service.kasko.KaskoPolicyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kasko")
public class KaskoController {

    private final KaskoCarModelService kaskoCarModelService;
    private final KaskoCarModelMapper kaskoCarModelMapper;

    private final KaskoPolicyService kaskoPolicyService;

    @GetMapping("/car-models")
    public List<KaskoCarModelDto> getAllCarModels() {
        List<KaskoCarModel> carModels = kaskoCarModelService.getAllCarModels();
        return kaskoCarModelMapper.kaskoCarModelListToKaskoCarModelDtoList(carModels);
    }

    @GetMapping("/policies")
    public List<KaskoPolicyDto> getKaskoPolicies(@RequestParam(name = "brand") String brand,
                                                 @RequestParam(name = "model") String model,
                                                 @RequestParam(name = "manufactureYear") int manufactureYear,
                                                 @RequestParam(name = "drivingExperience") String drivingExperience) {
        return kaskoPolicyService.calculatePolicyCost(brand, model, manufactureYear, drivingExperience);
    }

}