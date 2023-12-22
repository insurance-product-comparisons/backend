package ru.ya.insurance.controller.newInsuranceRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.ya.insurance.dto.newInsuranceRequest.NewInsuranceRequestDto;
import ru.ya.insurance.model.newInsuranceRequest.NewInsuranceRequest;
import ru.ya.insurance.service.newInsuranceRequest.NewInsuranceRequestService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/new-insurance-request")
public class NewInsuranceRequestController {

    private final NewInsuranceRequestService newInsuranceRequestService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewInsuranceRequest addNewInsuranceRequest(@Valid @RequestBody NewInsuranceRequestDto newInsuranceRequestDto) {
        return newInsuranceRequestService.addNewInsuranceRequest(newInsuranceRequestDto);
    }

}