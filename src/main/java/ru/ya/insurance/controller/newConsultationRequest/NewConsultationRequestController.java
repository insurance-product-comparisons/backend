package ru.ya.insurance.controller.newConsultationRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.ya.insurance.dto.newConsultationRequest.NewConsultationRequestDto;
import ru.ya.insurance.model.newConsultationRequest.NewConsultationRequest;
import ru.ya.insurance.service.newConsultationRequest.NewConsultationRequestService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/new-consultation-request")
public class NewConsultationRequestController {

    private final NewConsultationRequestService newConsultationRequestService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewConsultationRequestDto addNewConsultationRequest(@Valid @RequestBody NewConsultationRequest newConsultationRequest) {
        return newConsultationRequestService.addNewConsultationRequest(newConsultationRequest);
    }

}