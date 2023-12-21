package ru.ya.insurance.mapper.insurance;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.ya.insurance.dto.insurance.FeatureDto;
import ru.ya.insurance.dto.insurance.InsuranceOfferCardDto;
import ru.ya.insurance.model.company.License;
import ru.ya.insurance.model.insurance.Feature;
import ru.ya.insurance.model.insurance.Insurance;
import ru.ya.insurance.model.insurance.RequiredDocument;
import ru.ya.insurance.model.insurance.ValidityPeriod;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InsuranceOfferCardMapper {
    @Mapping(source = "company.logo", target = "companyLogo")
    @Mapping(source = "company.name", target = "companyName")
    @Mapping(source = "company.licenses", target = "companyLicenses")
    @Mapping(source = "company.rating", target = "companyRating")
    @Mapping(source = "name", target = "insuranceName")
    @Mapping(source = "description", target = "insuranceDescription")
    @Mapping(source = "validityPeriods", target = "insuranceValidityPeriods")
    @Mapping(source = "features", target = "insuranceFeatures")
    @Mapping(source = "requiredDocuments", target = "insuranceRequiredDocuments")
    @Mapping(source = "processingTime", target = "insuranceProcessingTime")
    InsuranceOfferCardDto insuranceToInsuranceDto(Insurance insurance);

    /**
     * default методы подключаются автоматически и маппят только определенные поля - из моделей в Dto.
     * <p>
     * Например, из базы приходит объект с полем List<RequiredDocument> requiredDocuments,
     * а в Dto нам нужно включить List<String> requiredDocuments,
     * где String - это поле из RequiredDocument - String document.
     * <p>
     * Пишем такой метод, и все работает.
     * default String mapRequiredDocument(RequiredDocument requiredDocument) {
     * return requiredDocument.getDocument();
     * }
     */

    default String mapLicence(License license) {
        return license.getLicense();
    }

    default Integer mapValidityPeriod(ValidityPeriod validityPeriod) {
        return validityPeriod.getValidityPeriod();
    }

    default String mapRequiredDocument(RequiredDocument requiredDocument) {
        return requiredDocument.getDocument();
    }

    default FeatureDto mapRequiredDocument(Feature feature) {
        return new FeatureDto(feature.getName(), feature.getDescription());
    }
}
