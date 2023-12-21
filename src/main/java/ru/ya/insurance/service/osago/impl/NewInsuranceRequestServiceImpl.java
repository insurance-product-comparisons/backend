package ru.ya.insurance.service.osago.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.dto.osago.NewInsuranceRequestDto;
import ru.ya.insurance.mapper.osago.NewInsuranceRequestMapper;
import ru.ya.insurance.model.osago.NewInsuranceRequest;
import ru.ya.insurance.repository.osago.NewInsuranceRequestRepository;
import ru.ya.insurance.service.osago.NewInsuranceRequestService;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class NewInsuranceRequestServiceImpl implements NewInsuranceRequestService {

    private final NewInsuranceRequestRepository newInsuranceRequestRepository;
    private final NewInsuranceRequestMapper newInsuranceRequestMapper;

    @Override
    @Transactional
    public NewInsuranceRequest addNewInsuranceRequest(NewInsuranceRequestDto newInsuranceRequestDto) {
        NewInsuranceRequest newInsuranceRequest =
                newInsuranceRequestMapper.newInsuranceRequestDtoToNewInsuranceRequest(newInsuranceRequestDto);
        return newInsuranceRequestRepository.save(newInsuranceRequest);
    }

}