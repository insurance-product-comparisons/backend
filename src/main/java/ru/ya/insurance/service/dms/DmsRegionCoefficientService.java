package ru.ya.insurance.service.dms;

import ru.ya.insurance.model.region.RegionCoefficient;

public interface DmsRegionCoefficientService {

    RegionCoefficient findCoefficientByRegion(String region);
}
