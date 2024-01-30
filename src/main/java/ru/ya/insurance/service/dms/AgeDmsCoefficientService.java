package ru.ya.insurance.service.dms;

import ru.ya.insurance.model.dms.AgeDmsCoefficient;

import java.util.List;

public interface AgeDmsCoefficientService {

    AgeDmsCoefficient getDmsCoefficientByAge(int age);

    List<AgeDmsCoefficient> getAllDmsCoefficients();
}
