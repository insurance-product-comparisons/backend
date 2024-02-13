package ru.ya.insurance.mapper.users;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.ya.insurance.dto.osago.BaseRateDto;
import ru.ya.insurance.dto.users.UserDto;
import ru.ya.insurance.model.osago.BaseRateCoefficient;
import ru.ya.insurance.model.user.User;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsersMapper {

    User userDtoToUser(UserDto userDto);

    List<BaseRateDto> baseRateCoefficientListToBaseRateDtoList(List<BaseRateCoefficient> baseRateCoefficients);
}
