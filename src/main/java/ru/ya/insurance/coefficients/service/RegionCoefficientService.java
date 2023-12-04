package ru.ya.insurance.coefficients.service;


import org.springframework.stereotype.Service;
import ru.ya.insurance.coefficients.model.dto.RegionCoefficientOutDto;
import ru.ya.insurance.coefficients.model.dto.SubRegionOutDto;

import java.util.List;

@Service
public interface RegionCoefficientService {
    List<RegionCoefficientOutDto> findAll();

    List<SubRegionOutDto> getByQuery(String query);

    SubRegionOutDto getById(Long id);

}
