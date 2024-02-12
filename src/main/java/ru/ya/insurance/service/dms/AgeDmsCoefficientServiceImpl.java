package ru.ya.insurance.service.dms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.insurance.exception.NotFoundException;
import ru.ya.insurance.model.dms.AgeDmsCoefficient;
import ru.ya.insurance.repository.dms.AgeDmsCoefficientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgeDmsCoefficientServiceImpl implements AgeDmsCoefficientService {

    private final AgeDmsCoefficientRepository ageDmsCoefficientRepository;

    @Override
    public AgeDmsCoefficient getDmsCoefficientByAge(int age) {
        AgeDmsCoefficient dmsCoefficientByAge = ageDmsCoefficientRepository
                .findByAge(age)
                .orElseThrow(() -> new NotFoundException("Коэффициент дмс  по возрасту: " + age + " не найден"));
        return dmsCoefficientByAge;
    }


    @Override
    public List<AgeDmsCoefficient> getAllDmsCoefficients() {
        return ageDmsCoefficientRepository.findAll();
    }
}