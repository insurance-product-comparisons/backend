package ru.ya.insurance.controller.dms;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.dto.dms.DmsRequestDto;
import ru.ya.insurance.dto.dms.DmsResponseDto;
import ru.ya.insurance.service.dms.DmsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dms")
@Validated
public class DmsController {

    private final DmsService dmsService;

    @GetMapping("/car-models")
    public ResponseEntity<List<DmsResponseDto>> getAll(@Valid DmsRequestDto dmsRequestDto) {
        return ResponseEntity.ok(dmsService.getAllDms(dmsRequestDto));
    }

}