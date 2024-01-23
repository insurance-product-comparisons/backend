package ru.ya.insurance.controller.kasko;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.dto.kasko.KaskoCarModelDto;
import ru.ya.insurance.mapper.kasko.KaskoCarModelMapper;
import ru.ya.insurance.model.kasko.KaskoCarModel;
import ru.ya.insurance.service.kasko.KaskoCarModelService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kasko")
public class KaskoController {

    private final KaskoCarModelService kaskoCarModelService;
    private final KaskoCarModelMapper kaskoCarModelMapper;

    @GetMapping("/car-models")
    public List<KaskoCarModelDto> getAllCarModels() {
        List<KaskoCarModel> carModels = kaskoCarModelService.getAllCarModels();
        return kaskoCarModelMapper.kaskoCarModelListToKaskoCarModelDtoList(carModels);
    }

}