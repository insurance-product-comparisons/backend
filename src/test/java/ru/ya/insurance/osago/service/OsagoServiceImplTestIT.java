package ru.ya.insurance.osago.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.osago.model.BaseRate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest(
        properties = "db.name=test",
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class OsagoServiceImplTestIT {
    private final OsagoServiceImpl service;

    @Test
    void shouldReturnBaseRateDtoList() {
        List<BaseRate> baseRates = service.getVehicleTypes();

        assertEquals(12, baseRates.size());

        assertEquals("Мотоциклы, мопеды и лёгкие квадроциклы (\"А\", \"М\")", baseRates.get(0).getTransportType());
        assertEquals(324, (int) baseRates.get(0).getMinRate());
        assertEquals(2536, (int) baseRates.get(0).getMaxRate());
    }
}