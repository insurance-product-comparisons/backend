package ru.ya.insurance.service.insurance.impl;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.enums.InsuranceType;
import ru.ya.insurance.model.company.Company;
import ru.ya.insurance.model.company.License;
import ru.ya.insurance.model.insurance.Feature;
import ru.ya.insurance.model.insurance.Insurance;
import ru.ya.insurance.model.insurance.RequiredDocument;
import ru.ya.insurance.model.insurance.ValidityPeriod;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Transactional
@SpringBootTest(
        properties = "db.name=test",
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class InsuranceOfferCardServiceImplIT {
    private final EntityManager em;
    private final InsuranceOfferCardServiceImpl service;

    @Test
    void shouldReturnInsuranceModel() {
        Company company = new Company();
        License license = new License();

        Insurance insurance = new Insurance();
        Feature feature = new Feature();
        RequiredDocument requiredDocument = new RequiredDocument();
        ValidityPeriod validityPeriod = new ValidityPeriod();

        company.setName("Company name");
        company.setDescription("Company description");
        company.setRating(5.0);
        company.setLogo("/logo.png");

        license.setCompany(company);
        license.setLicense("/licence.pdf");

        insurance.setCompany(company);
        insurance.setType(InsuranceType.OSAGO);
        insurance.setName("Insurance name");
        insurance.setDescription("Insurance description");
        insurance.setProcessingTime(1);

        feature.setInsurance(insurance);
        feature.setName("Feature name");
        feature.setDescription("Feature description");

        requiredDocument.setInsurance(insurance);
        requiredDocument.setDocument("Document name");

        validityPeriod.setInsurance(insurance);
        validityPeriod.setValidityPeriod(30);

        em.persist(company);
        em.persist(license);
        em.persist(insurance);
        em.persist(feature);
        em.persist(requiredDocument);
        em.persist(validityPeriod);

        em.clear();

        Long companyId = company.getId();
        Long insuranceId = insurance.getId();

        Insurance getInsurance = service.findInsuranceOfferCardById(companyId, insuranceId);

        assertEquals(insuranceId, getInsurance.getId());
        assertEquals(company, getInsurance.getCompany());
        assertEquals(companyId, getInsurance.getCompany().getId());
        assertEquals(insurance.getName(), getInsurance.getName());
        assertEquals(insurance.getType(), getInsurance.getType());
        assertEquals(insurance.getDescription(), getInsurance.getDescription());
        assertNotNull(getInsurance.getCompany().getLicenses());
        assertNotNull(getInsurance.getFeatures());
        assertNotNull(getInsurance.getRequiredDocuments());
        assertNotNull(getInsurance.getValidityPeriods());
    }
}