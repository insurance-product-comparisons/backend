//package ru.ya.insurance.service.dms;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import ru.ya.insurance.dto.dms.DmsRequestDto;
//import ru.ya.insurance.dto.dms.DmsShortDto;
//import ru.ya.insurance.model.company.Company;
//import ru.ya.insurance.repository.company.CompanyRepository;
//import ru.ya.insurance.repository.dms.AgeDmsCoefficientRepository;
//import ru.ya.insurance.repository.region.RegionCoefficientRepository;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//class DmsServiceImplTest {
//
//    @Mock
//    private CompanyRepository companyRepository;
//
//    @Mock
//    private AgeDmsCoefficientRepository ageDmsCoefficientRepository;
//
//    @Mock
//    private RegionCoefficientRepository regionCoefficientRepository;
//
//    @InjectMocks
//    private DmsServiceImpl dmsService;
//
//    @Test
//    void testGetAllDms() {
//        // Mock data
//        DmsRequestDto dmsRequestDto = new DmsRequestDto(1, 12, "Уфа");
//        List<Company> companies = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            companies.add(new Company());
//        }
//
//        when(companyRepository.findAll()).thenReturn(companies);
//
//        // Call the method
//        List<DmsShortDto> result = dmsService.getAllDms(dmsRequestDto);
//
//        // Assertions
//        // Perform assertions based on your expected result
//        // For example, you can check if the result size is as expected
//        assertEquals(10, result.size());
//
//        // Verify that the repository method was called
//        verify(companyRepository, times(1)).findAll();
//    }
//}