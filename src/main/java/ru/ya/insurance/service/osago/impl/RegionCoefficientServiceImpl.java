package ru.ya.insurance.service.osago.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.model.region.Region;
import ru.ya.insurance.repository.region.RegionRepository;
import ru.ya.insurance.service.osago.RegionCoefficientService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionCoefficientServiceImpl implements RegionCoefficientService {
    private final RegionRepository regionRepository;

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

}