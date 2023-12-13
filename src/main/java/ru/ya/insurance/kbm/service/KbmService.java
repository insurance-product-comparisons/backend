package ru.ya.insurance.kbm.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.kbm.dto.KbmDto;
import ru.ya.insurance.kbm.mapper.KbmMapper;
import ru.ya.insurance.kbm.repository.KbmRepository;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@AllArgsConstructor
@Service
public class KbmService {

    public KbmRepository kbmRepository;
    public KbmMapper kbmMapper;

    public List<KbmDto> getKbmDtoList() {
        return kbmRepository.findAll().stream()
                .map(kbmMapper::kbmToKbmDto)
                .collect(Collectors.toList());
    }

}