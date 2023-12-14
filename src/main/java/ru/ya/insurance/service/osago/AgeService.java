package ru.ya.insurance.service.osago;

import ru.ya.insurance.model.osago.Age;

import java.util.List;

public interface AgeService {
    Age getAgeById(Long id);

    List<Age> getAgeList();
}
