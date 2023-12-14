package ru.ya.insurance.osago.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ya.insurance.dto.osago.SubRegionDto;
import ru.ya.insurance.mapper.osago.SubRegionMapper;
import ru.ya.insurance.model.osago.RegionCoefficient;
import ru.ya.insurance.repository.osago.RegionCoefficientRepository;
import ru.ya.insurance.service.osago.impl.RegionCoefficientServiceImpl;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class RegionCoefficientServiceImplTest {
    @Mock
    private RegionCoefficientRepository mockRegionCoefficientRepository;
    @Mock
    private SubRegionMapper mockSubRegionMapper;

    @InjectMocks
    private RegionCoefficientServiceImpl regionCoefficientService;

    @DisplayName("Find all action")
    @Test
    void findAll() {
        regionCoefficientService.findAll();
        Mockito.verify(mockRegionCoefficientRepository).findAll();
    }

    @DisplayName("Get region List by Query")
    @Test
    void getByQuery() {
        regionCoefficientService.getByQuery("test query");
        Mockito.verify(mockRegionCoefficientRepository).findAllByQuery(Mockito.anyString());
        Mockito.verify(mockSubRegionMapper).regionCoefficientListToSubregionDtoList(Mockito.any());
    }

    @DisplayName("Get region by ID")
    @Test
    void getById() {
        Long expectedId = 17L;

        Optional<RegionCoefficient> region = Optional.of(
                new RegionCoefficient(
                        expectedId,
                        "2023",
                        "22.22",
                        "Test",
                        new BigDecimal(1),
                        new BigDecimal(0.68)
                ));
        SubRegionDto subDto = new SubRegionDto(
                expectedId,
                "Тестовый город",
                new BigDecimal(1),
                new BigDecimal(0.68)
        );
        Mockito.doReturn(region).when(mockRegionCoefficientRepository).findById(Mockito.anyLong());
        Mockito.doReturn(subDto).when(mockSubRegionMapper).regionCoefficientToSubRegionDto(Mockito.any(RegionCoefficient.class));

        SubRegionDto result = regionCoefficientService.getById(expectedId);

        Assertions.assertEquals(expectedId, result.getId());
    }
}