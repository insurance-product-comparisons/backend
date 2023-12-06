package ru.ya.insurance.kbm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.kbm.dto.KbmDto;
import ru.ya.insurance.kbm.mapper.KbmMapper;
import ru.ya.insurance.kbm.repository.KbmRepository;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class KbmService {

    private final KbmRepository kbmRepository;

    public List<KbmDto> getKbmDtoList() {
        return kbmRepository.findAll().stream()
                .map(KbmMapper.INSTANCE::kbmToKbmDto)
                .collect(Collectors.toList());
    }

}