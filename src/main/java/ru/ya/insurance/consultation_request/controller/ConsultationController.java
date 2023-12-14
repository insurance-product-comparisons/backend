package ru.ya.insurance.consultation_request.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.consultation_request.dto.RequestConsultationDto;

@Validated
@RestController
@Slf4j
@AllArgsConstructor
public class ConsultationController {

    public RequestConsultationDto postRequest() {
        return null;
    }
//Нужно создать эндпоинт POST: consultation-request, на котором будет происходить валидация
//ввода пользователя и будет выбрасываться один из статусов:
//- Status code: 201 Created - успех
//- Status code: 400 Bad Request - некорректные данные

}
