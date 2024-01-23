package ru.ya.insurance.controller.newInsuranceRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.ya.insurance.dto.newInsuranceRequest.NewInsuranceRequestDto;
import ru.ya.insurance.mapper.newInsuranceRequest.NewInsuranceRequestMapper;
import ru.ya.insurance.model.newInsuranceRequest.NewInsuranceRequest;
import ru.ya.insurance.service.newInsuranceRequest.NewInsuranceRequestService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/new-insurance-request")
public class NewInsuranceRequestController {

    private final NewInsuranceRequestService newInsuranceRequestService;
    private final NewInsuranceRequestMapper newInsuranceRequestMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewInsuranceRequestDto addNewInsuranceRequest(@Valid @RequestBody NewInsuranceRequest newInsuranceRequest) {
        return newInsuranceRequestMapper.newInsuranceRequestToNewInsuranceRequestDto(
                newInsuranceRequestService.addNewInsuranceRequest(newInsuranceRequest));
    }

}