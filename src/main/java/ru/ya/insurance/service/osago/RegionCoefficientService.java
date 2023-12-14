package ru.ya.insurance.service.osago;

import ru.ya.insurance.dto.osago.RegionDto;
import ru.ya.insurance.dto.osago.SubRegionDto;

import java.util.List;

public interface RegionCoefficientService {
    List<RegionDto> findAll();

    List<SubRegionDto> getByQuery(String query);

    SubRegionDto getById(Long id);

}
