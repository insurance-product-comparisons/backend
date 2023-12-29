package ru.ya.insurance.osago.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ya.insurance.mapper.osago.RegionMapper;
import ru.ya.insurance.repository.osago.RegionRepository;
import ru.ya.insurance.service.osago.impl.RegionCoefficientServiceImpl;

@ExtendWith(MockitoExtension.class)
class RegionCoefficientServiceImplTest {
    @Mock
    private RegionRepository mockRegionRepository;
    @Mock
    private RegionMapper mockRegionMapper;

    @InjectMocks
    private RegionCoefficientServiceImpl regionCoefficientService;

    @DisplayName("Find all action")
    @Test
    void findAll() {
        regionCoefficientService.findAll();
        Mockito.verify(mockRegionRepository).findAll();
    }

}