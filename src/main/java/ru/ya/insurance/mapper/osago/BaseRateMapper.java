package ru.ya.insurance.mapper.osago;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.ya.insurance.dto.osago.BaseRateDto;
import ru.ya.insurance.model.osago.BaseRateCoefficient;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseRateMapper {
    BaseRateDto baseRateCoefficientToBaseRateDto(BaseRateCoefficient baseRateCoefficient);

    List<BaseRateDto> baseRateCoefficientListToBaseRateDtoList(List<BaseRateCoefficient> baseRateCoefficients);
}
