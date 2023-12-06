package ru.ya.insurance.kbm.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.kbm.dto.KbmDto;
import ru.ya.insurance.kbm.service.KbmService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/kbm")
public class KbmController {

    public KbmService kbmService;

    @GetMapping()
    public List<KbmDto> getKbmDtoList() {
        return kbmService.getKbmDtoList();
    }

}