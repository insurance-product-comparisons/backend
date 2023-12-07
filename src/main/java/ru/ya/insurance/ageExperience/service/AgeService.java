package ru.ya.insurance.ageExperience.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.ageExperience.dto.AgeDto;
import ru.ya.insurance.ageExperience.mapper.AgeMapper;
import ru.ya.insurance.ageExperience.model.Age;
import ru.ya.insurance.ageExperience.repository.AgeRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AgeService {

    private final AgeMapper ageMapper;
    private final AgeRepository ageRepository;

    public Age getAgeById(Long id) {
        return ageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Коэффициент \"Возраст\" не найден"));
    }

    public List<AgeDto> getAgeDtoList() {
        return ageRepository.findAll().stream()
                .map(ageMapper::ageToDto)
                .collect(Collectors.toList());
    }

}