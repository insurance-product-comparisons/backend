package ru.ya.insurance.osago.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.osago.model.BaseRate;
import ru.ya.insurance.osago.repository.BaseRateRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OsagoServiceImpl implements OsagoService {
    private final BaseRateRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<BaseRate> getVehicleTypes() {
        return repository.findAll();
    }
}
