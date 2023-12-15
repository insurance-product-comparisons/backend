package ru.ya.insurance.service.osago.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.dto.osago.RegionDto;
import ru.ya.insurance.dto.osago.SubRegionDto;
import ru.ya.insurance.exception.NotFoundException;
import ru.ya.insurance.mapper.osago.RegionMapper;
import ru.ya.insurance.mapper.osago.SubRegionMapper;
import ru.ya.insurance.model.osago.RegionCoefficient;
import ru.ya.insurance.repository.osago.RegionCoefficientRepository;
import ru.ya.insurance.service.osago.RegionCoefficientService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionCoefficientServiceImpl implements RegionCoefficientService {
    private final RegionCoefficientRepository regionCoefficientRepository;
    private final RegionMapper regionMapper;
    private final SubRegionMapper subRegionMapper;

    @Override
    public List<RegionDto> findAll() {
        List<RegionDto> dtoList = new ArrayList<>();

        List<RegionCoefficient> regionList = regionCoefficientRepository.findAll();
        for (RegionCoefficient regionCoefficient : regionList) {
            if (!regionCoefficient.getNumber().contains(".")) {
                List<RegionCoefficient> subRegionList = regionCoefficientRepository.findAllByNumberExcludeZeroRegion(regionCoefficient.getNumber());
                List<SubRegionDto> subDtoList = subRegionMapper.regionCoefficientListToSubregionDtoList(subRegionList);
                dtoList.add(regionMapper.regionCoefficientToRegionDto(regionCoefficient, subDtoList));
            }
        }

        return dtoList;
    }

    @Override
    public List<SubRegionDto> getByQuery(String query) {
        return subRegionMapper.regionCoefficientListToSubregionDtoList(regionCoefficientRepository.findAllByQuery(query));
    }

    @Override
    public SubRegionDto getById(Long regionId) {
        return regionCoefficientRepository.findById(regionId)
                .map(subRegionMapper::regionCoefficientToSubRegionDto)
                .orElseThrow(() -> new NotFoundException("Id not found"));
    }

}