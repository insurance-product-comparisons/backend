package ru.ya.insurance.mapper.common;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.ya.insurance.dto.common.InsuranceDto;
import ru.ya.insurance.model.common.Insurance;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InsuranceOfferCardMapper {
    @Mapping(source = "company.name", target = "companyName")
    @Mapping(source = "company.logo", target = "companyLogo")
    @Mapping(source = "company.licenses", target = "companyLicenses")
    @Mapping(source = "name", target = "insuranceName")
    @Mapping(source = "description", target = "insuranceDescription")
    @Mapping(source = "processingTime", target = "insuranceProcessingTime")
    @Mapping(source = "validityPeriods", target = "insuranceValidityPeriods")
    @Mapping(source = "features", target = "insuranceFeatures")
    @Mapping(source = "requiredDocuments", target = "insuranceRequiredDocuments")
    InsuranceDto insuranceToInsuranceDto(Insurance insurance);
}
