package ru.ya.insurance.coefficients.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.coefficients.dto.RegionCoefficientOutDto;
import ru.ya.insurance.coefficients.dto.SubRegionOutDto;
import ru.ya.insurance.coefficients.mapper.RegionMapper;
import ru.ya.insurance.coefficients.mapper.SubRegionMapper;
import ru.ya.insurance.coefficients.model.RegionCoefficient;
import ru.ya.insurance.coefficients.repository.RegionCoefficientRepository;
import ru.ya.insurance.coefficients.service.RegionCoefficientService;
import ru.ya.insurance.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionCoefficientServiceImpl implements RegionCoefficientService {
    private final RegionCoefficientRepository regionCoefficientRepository;
    private final RegionMapper regionMapper;
    private final SubRegionMapper subRegionMapper;

    /**
     * 1. Получить все записи.
     * 2. Записи у которых номер без точки, является корневым.
     * 3. Получить по корневому номеру все подзаписи, которые являются N.NN
     */
    @Override
    public List<RegionCoefficientOutDto> findAll() {
        List<RegionCoefficientOutDto> dtoList = new ArrayList<>();

        List<RegionCoefficient> regionList = regionCoefficientRepository.findAll();
        for (RegionCoefficient regionCoefficient : regionList) {
            if (!regionCoefficient.getNumber().contains(".")) {
                List<RegionCoefficient> subRegionList = regionCoefficientRepository.findAllByNumberExcludeZeroRegion(regionCoefficient.getNumber());
                List<SubRegionOutDto> subDtoList = subRegionMapper.toListDto(subRegionList);
                dtoList.add(regionMapper.toDto(regionCoefficient, subDtoList));
            }
        }

        return dtoList;
    }

    @Override
    public List<SubRegionOutDto> getByQuery(String query) {
        return subRegionMapper.toListDto(regionCoefficientRepository.findAllByQuery(query));
    }

    @Override
    public SubRegionOutDto getById(Long regionId) {
        return regionCoefficientRepository.findById(regionId)
                .map(subRegionMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Id not found"));
    }

}