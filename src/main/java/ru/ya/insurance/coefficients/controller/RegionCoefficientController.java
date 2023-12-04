package ru.ya.insurance.coefficients.controller;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.coefficients.model.dto.RegionCoefficientOutDto;
import ru.ya.insurance.coefficients.model.dto.SubRegionOutDto;
import ru.ya.insurance.coefficients.service.RegionCoefficientService;

import java.util.List;

/**
 * Получить Коэффициента страховых тарифов по регионам
 */
@RestController
@AllArgsConstructor
@Slf4j
public class RegionCoefficientController {
    private RegionCoefficientService regionCoefficientService;

    /**
     * Получить весь список
     */
    @GetMapping(value = "/region-coefficient/all")
    public List<RegionCoefficientOutDto> getRegionList() {
        log.info("GET /region-coefficient/all");
        return regionCoefficientService.findAll();
    }

    /**
     * Произвести поиск вхождения по списку
     */
    @GetMapping(value = "/region-coefficient/search")
    public List<SubRegionOutDto> getRegionByQuery(@NotNull @NotBlank @RequestParam(name = "query", defaultValue = "") String query) {
        log.info("GET /region-coefficient/search: {}", query);
        return regionCoefficientService.getByQuery(query);
    }

    /**
     * Вернуть регион по ID
     */
    @GetMapping(value = "/region-coefficient/{regionId}")
    public SubRegionOutDto getRegionById(@NotNull @Min(value = 1) @PathVariable Long regionId) {
        if (regionId == null) {
            throw new IllegalArgumentException();
        }
        log.info("GET /region-coefficient/{}", regionId);
        return regionCoefficientService.getById(regionId);
    }

}
