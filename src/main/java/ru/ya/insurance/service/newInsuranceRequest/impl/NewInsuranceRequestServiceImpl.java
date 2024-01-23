package ru.ya.insurance.service.newInsuranceRequest.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.model.newInsuranceRequest.NewInsuranceRequest;
import ru.ya.insurance.repository.newInsuranceRequest.NewInsuranceRequestRepository;
import ru.ya.insurance.service.newInsuranceRequest.NewInsuranceRequestService;

@Service
@RequiredArgsConstructor
public class NewInsuranceRequestServiceImpl implements NewInsuranceRequestService {

    private final NewInsuranceRequestRepository newInsuranceRequestRepository;

    @Override
    @Transactional
    public NewInsuranceRequest addNewInsuranceRequest(NewInsuranceRequest newInsuranceRequest) {
        return newInsuranceRequestRepository.save(newInsuranceRequest);
    }
}