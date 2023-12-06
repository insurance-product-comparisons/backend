package ru.ya.insurance.kbm.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.kbm.dto.KbmDto;
import ru.ya.insurance.kbm.service.KbmService;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/kbm")
public class KbmController {

    private final KbmService kbmService;

    @GetMapping()
    public List<KbmDto> getKbmDtoList() {
        log.info("Получение перечня всех коэффициентов КБМ");
        return kbmService.getKbmDtoList();
    }

}