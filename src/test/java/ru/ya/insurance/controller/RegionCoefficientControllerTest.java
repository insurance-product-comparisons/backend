package ru.ya.insurance.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.ya.insurance.coefficients.controller.RegionCoefficientController;
import ru.ya.insurance.coefficients.dto.RegionCoefficientOutDto;
import ru.ya.insurance.coefficients.dto.SubRegionOutDto;
import ru.ya.insurance.coefficients.service.RegionCoefficientService;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class RegionCoefficientControllerTest {
    @Mock
    private RegionCoefficientService mockRegionCoefficientService;
    @InjectMocks
    private RegionCoefficientController controller;
    private RegionCoefficientOutDto dto;
    private SubRegionOutDto subDto;
    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
        subDto = new SubRegionOutDto(
                2L,
                "Тестовый город",
                new BigDecimal(1),
                new BigDecimal(0.68)
        );
        dto = new RegionCoefficientOutDto(
                1L,
                "Тестовый регион",
                List.of(subDto)
        );
    }

    @DisplayName("Get Region List")
    @Test
    void getRegionList() throws Exception {
        Mockito.doReturn(List.of(dto)).when(mockRegionCoefficientService).findAll();

        mvc.perform(get("/region-coefficient/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(dto.getId()))
                .andExpect(jsonPath("$[0].name").value(dto.getName()));
    }

    @DisplayName("Get Region List by Query")
    @Test
    void getRegionByQuery() throws Exception {
        Mockito.doReturn(List.of(dto)).when(mockRegionCoefficientService).getByQuery(Mockito.anyString());

        mvc.perform(get("/region-coefficient/search?query=Тест"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(dto.getId()))
                .andExpect(jsonPath("$[0].name").value(dto.getName()));
    }

    @DisplayName("Get Region by Id")
    @Test
    void getRegionById() throws Exception {
        Mockito.doReturn(subDto).when(mockRegionCoefficientService).getById(Mockito.anyLong());

        mvc.perform(get("/region-coefficient/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(subDto.getId()))
                .andExpect(jsonPath("$.name").value(subDto.getName()))
                .andExpect(jsonPath("$.coefficientExclude").value(subDto.getCoefficientExclude()))
                .andExpect(jsonPath("$.coefficientInclude").value(subDto.getCoefficientInclude()));
    }
}