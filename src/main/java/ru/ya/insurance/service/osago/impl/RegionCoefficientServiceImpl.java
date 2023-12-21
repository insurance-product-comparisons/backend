package ru.ya.insurance.service.osago.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.dto.osago.RegionDto;
import ru.ya.insurance.mapper.osago.RegionMapper;
import ru.ya.insurance.repository.osago.RegionRepository;
import ru.ya.insurance.service.osago.RegionCoefficientService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionCoefficientServiceImpl implements RegionCoefficientService {
    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;

    @Override
    public List<RegionDto> findAll() {
        return regionMapper.toDtoList(regionRepository.findAll());
    }

}
