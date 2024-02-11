package ru.ya.insurance.service.dms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.exception.NotFoundException;
import ru.ya.insurance.model.region.RegionCoefficient;
import ru.ya.insurance.repository.region.RegionCoefficientRepository;

@Service
@RequiredArgsConstructor
public class DmsRegionCoefficientServiceImpl implements DmsRegionCoefficientService {
    private final RegionCoefficientRepository dmsRegionCoefficientRepository;

    @Override
    public RegionCoefficient findCoefficientByRegion(String region) {
        return dmsRegionCoefficientRepository.findByRegion(region)
                .orElseThrow(() -> new NotFoundException("Коэфициент по региону " + region + " не найден"));
    }

}