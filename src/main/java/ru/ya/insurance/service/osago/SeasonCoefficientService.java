package ru.ya.insurance.service.osago;

import ru.ya.insurance.model.osago.SeasonCoefficient;

import java.util.List;

public interface SeasonCoefficientService {

    List<SeasonCoefficient> getSeasonCoefficientDtoList();

}