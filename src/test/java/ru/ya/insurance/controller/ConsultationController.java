package ru.ya.insurance.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.consultation_request.dto.RequestConsultationDto;

@RestController
public class ConsultationController {

    public RequestConsultationDto postRequest() {
        return null;
    }
//Нужно создать эндпоинт POST: consultation-request, на котором будет происходить валидация
//ввода пользователя и будет выбрасываться один из статусов:
//- Status code: 201 Created - успех
//- Status code: 400 Bad Request - некорректные данные

}
