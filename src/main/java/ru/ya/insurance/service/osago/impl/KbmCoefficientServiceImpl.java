package ru.ya.insurance.service.osago.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.model.osago.KbmCoefficient;
import ru.ya.insurance.repository.osago.KbmCoefficientRepository;
import ru.ya.insurance.service.osago.KbmCoefficientService;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class KbmCoefficientServiceImpl implements KbmCoefficientService {

    private final KbmCoefficientRepository kbmCoefficientRepository;

    @Override
    public List<KbmCoefficient> getKbmDtoList() {
        return kbmCoefficientRepository.findAll();
    }

}