package ru.ya.insurance.mapper.kasko;

import org.mapstruct.Mapper;
import ru.ya.insurance.dto.kasko.KaskoCarModelDto;
import ru.ya.insurance.model.kasko.KaskoCarModel;

import java.util.List;

@Mapper
public interface KaskoCarModelMapper {

    List<KaskoCarModelDto> kaskoCarModelListToKaskoCarModelDtoList(List<KaskoCarModel> carModelList);

}
