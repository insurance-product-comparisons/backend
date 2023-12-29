package ru.ya.insurance.service.newInsuranceRequest.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.dto.newInsuranceRequest.NewInsuranceRequestDto;
import ru.ya.insurance.mapper.newInsuranceRequest.NewInsuranceRequestMapper;
import ru.ya.insurance.model.newInsuranceRequest.NewInsuranceRequest;
import ru.ya.insurance.repository.newInsuranceRequest.NewInsuranceRequestRepository;
import ru.ya.insurance.service.newInsuranceRequest.NewInsuranceRequestService;

@Service
@RequiredArgsConstructor
public class NewInsuranceRequestServiceImpl implements NewInsuranceRequestService {

    private final NewInsuranceRequestRepository newInsuranceRequestRepository;
    private final NewInsuranceRequestMapper newInsuranceRequestMapper;

    @Override
    @Transactional
    public NewInsuranceRequestDto addNewInsuranceRequest(NewInsuranceRequest newInsuranceRequest) {
        return newInsuranceRequestMapper.newInsuranceRequestToNewInsuranceRequestDto(
                newInsuranceRequestRepository.save(newInsuranceRequest));
    }

}