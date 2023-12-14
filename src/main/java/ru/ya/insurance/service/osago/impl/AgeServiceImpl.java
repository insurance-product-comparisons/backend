package ru.ya.insurance.service.osago.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.model.osago.Age;
import ru.ya.insurance.repository.osago.AgeRepository;
import ru.ya.insurance.service.osago.AgeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgeServiceImpl implements AgeService {

    private final AgeRepository ageRepository;

    @Override
    public Age getAgeById(Long id) {
        return ageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Название поля \"Возраст\" не найдено"));
    }

    @Override
    public List<Age> getAgeList() {
        return ageRepository.findAll();
    }

}