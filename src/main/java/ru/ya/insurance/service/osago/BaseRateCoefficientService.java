package ru.ya.insurance.service.osago;

import ru.ya.insurance.model.osago.BaseRateCoefficient;

import java.util.List;

public interface BaseRateCoefficientService {
    List<BaseRateCoefficient> getBaseRateList();
}
