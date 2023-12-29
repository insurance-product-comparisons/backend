package ru.ya.insurance.osago.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.model.osago.BaseRateCoefficient;
import ru.ya.insurance.service.osago.impl.BaseRateCoefficientServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest(
        properties = "db.name=test",
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class OsagoServiceImplTestIT {
    private final BaseRateCoefficientServiceImpl service;

    @Test
    void shouldReturnBaseRateDtoList() {
        List<BaseRateCoefficient> baseRateCoefficients = service.getBaseRateList();

        assertEquals(12, baseRateCoefficients.size());

        assertEquals("Мотоциклы, мопеды и лёгкие квадроциклы (\"А\", \"М\")", baseRateCoefficients.get(0).getTransportType());
        assertEquals(324, (int) baseRateCoefficients.get(0).getMinRate());
        assertEquals(2536, (int) baseRateCoefficients.get(0).getMaxRate());
    }
}