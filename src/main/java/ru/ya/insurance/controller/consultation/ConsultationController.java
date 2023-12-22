package ru.ya.insurance.controller.consultation;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.ya.insurance.dto.consultation.NewConsultationDto;
import ru.ya.insurance.dto.consultation.RequestConsultationDto;
import ru.ya.insurance.service.consultation.ConsultationService;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/consultation-request")
public class ConsultationController {
    private final ConsultationService consultationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RequestConsultationDto addNewConsultationRequest(
            @Valid @RequestBody NewConsultationDto newConsultationDto) {
        return consultationService.save(newConsultationDto);
    }
}
