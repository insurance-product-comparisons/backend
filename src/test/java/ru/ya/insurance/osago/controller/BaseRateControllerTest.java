package ru.ya.insurance.osago.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.ya.insurance.osago.dto.VehicleType;
import ru.ya.insurance.osago.dto.VehicleTypeDto;
import ru.ya.insurance.osago.mapper.VehicleTypeDtoMapper;
import ru.ya.insurance.osago.model.BaseRate;
import ru.ya.insurance.osago.service.OsagoService;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = BaseRateController.class)
class BaseRateControllerTest {
    @MockBean
    private OsagoService service;

    @MockBean
    private VehicleTypeDtoMapper mapper;

    @Autowired
    private MockMvc mvc;

    private final List<BaseRate> baseRates = List.of(
            new BaseRate(1, "A", 324, 2536),
            new BaseRate(2, "B", 852, 5722)
    );

    private final VehicleTypeDto vehicleTypeDto = new VehicleTypeDto(List.of(
            new VehicleType(1, "A"),
            new VehicleType(2, "B")
    ));


    @Test
    void shouldReturnVehicleTypeDtoList() throws Exception {
        when(service.getVehicleTypes()).thenReturn(baseRates);
        when(mapper.mapToVehicleTypeDto(baseRates)).thenReturn(vehicleTypeDto);

        mvc.perform(get("/osago/base-rate/vehicle-types/all")
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.vehicleTypes[0].id", is(baseRates.get(0).getId())))
                .andExpect(jsonPath("$.vehicleTypes[0].transportType", is(baseRates.get(0).getTransportType())))
                .andExpect(jsonPath("$.vehicleTypes[1].id", is(baseRates.get(1).getId())))
                .andExpect(jsonPath("$.vehicleTypes[1].transportType", is(baseRates.get(1).getTransportType())));
    }
}