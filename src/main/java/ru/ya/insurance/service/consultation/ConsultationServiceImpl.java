package ru.ya.insurance.service.consultation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.dto.consultation.NewConsultationDto;
import ru.ya.insurance.dto.consultation.RequestConsultationDto;
import ru.ya.insurance.mapper.consultation.ConsultationRequestMapper;
import ru.ya.insurance.model.consultation.ConsultationRequest;
import ru.ya.insurance.repository.consultation.ConsultationRequestRepository;

@Service
@RequiredArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {
    ConsultationRequestRepository consultationRequestRepository;
    ConsultationRequestMapper consultationRequestMapper;

    @Override
    @Transactional
    public RequestConsultationDto save(NewConsultationDto newConsultationDto) {

        ConsultationRequest consultationRequest = consultationRequestMapper
            .newConsultationDtoToConsultationRequest(newConsultationDto);
        return consultationRequestMapper
            .consultationRequestToRequestConsultationDto(consultationRequestRepository
                .save(consultationRequest));
    }
}
