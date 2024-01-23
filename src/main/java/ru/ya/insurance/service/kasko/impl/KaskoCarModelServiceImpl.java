package ru.ya.insurance.service.kasko.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.model.kasko.KaskoCarModel;
import ru.ya.insurance.repository.kasko.KaskoCarModelRepository;
import ru.ya.insurance.service.kasko.KaskoCarModelService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KaskoCarModelServiceImpl implements KaskoCarModelService {

    private final KaskoCarModelRepository kaskoCarModelRepository;

    public List<KaskoCarModel> getAllCarModels() {
        return kaskoCarModelRepository.findAll();
    }

}