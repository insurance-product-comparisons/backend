package ru.ya.insurance.coefficients.controller;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ya.insurance.coefficients.dto.RegionCoefficientOutDto;
import ru.ya.insurance.coefficients.dto.SubRegionOutDto;
import ru.ya.insurance.coefficients.service.RegionCoefficientService;

import java.util.List;

/**
 * Получить Коэффициента страховых тарифов по регионам
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/region-coefficient")
public class RegionCoefficientController {
    private final RegionCoefficientService regionCoefficientService;

    /**
     * Получить весь список
     */
    @GetMapping(value = "/all")
    public ResponseEntity<List<RegionCoefficientOutDto>> getRegionList() {
        return ResponseEntity.ok(regionCoefficientService.findAll());
    }

    /**
     * Произвести поиск вхождения по списку
     */
    @GetMapping(value = "/search")
    public ResponseEntity<List<SubRegionOutDto>> getRegionByQuery(@NotNull @NotBlank @RequestParam(name = "query", defaultValue = "") String query) {
        return ResponseEntity.ok(regionCoefficientService.getByQuery(query));
    }

    /**
     * Вернуть регион по ID
     */
    @GetMapping(value = "/{regionId}")
    public ResponseEntity<SubRegionOutDto> getRegionById(@NotNull @Min(value = 1) @PathVariable Long regionId) {
        return ResponseEntity.ok(regionCoefficientService.getById(regionId));
    }

}
