package services;

import data.models.Resident;
import data.repository.Residents;
import data.repository.ResidentsRepository;
import dto.response.ResidentServiceResponse;
import dto.request.ResidentServicesRequest;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResidentServiceImplTest {
/*
   // ResidentServiceImpl residentService;
    Residents residents;
    @BeforeEach
    public void setUp(){
   //     residentService = new ResidentServiceImpl();
        residents = new Residents();
    }



 */



    @Test
    public void testResgister(){

        ResidentsRepository residents = new Residents();
        ResidentServiceImpl residentService = new ResidentServiceImpl();
        ResidentServicesRequest residentServicesRequest = new ResidentServicesRequest();
        residentServicesRequest.setFullName("Eletu Usman");
        residentServicesRequest.setEmail("@yahho.com");
        residentServicesRequest.setPhonenumber("09134969393");

        residentService.register(residentServicesRequest);


        assertEquals(1,residents.count());

    }

    @Test
    public void testCantResgistertwices(){

        ResidentsRepository residents = new Residents();
        ResidentServiceImpl residentService = new ResidentServiceImpl();
        ResidentServicesRequest residentServicesRequest = new ResidentServicesRequest();
        residentServicesRequest.setFullName("Eletu Usman");
        residentServicesRequest.setEmail("@yahho.com");
        residentServicesRequest.setPhonenumber("09134969393");

        residentService.register(residentServicesRequest);


        ResidentServicesRequest residentServicesRequest1 = new ResidentServicesRequest();
        residentServicesRequest1.setFullName("Eletu Usman");
        residentServicesRequest1.setEmail("@yahho.com");
        residentServicesRequest1.setPhonenumber("09134969393");

        residentService.register(residentServicesRequest1);


        assertEquals(1,residents.count());

    }

    @Test
    public void testResgi(){

        ResidentsRepository residents = new Residents();

        ResidentServiceImpl residentService = new ResidentServiceImpl();
        ResidentServicesRequest residentServicesRequest = new ResidentServicesRequest();
        residentServicesRequest.setFullName("Eletu Usman");
        residentServicesRequest.setEmail("@yahho.com");
        residentServicesRequest.setPhonenumber("09134969393");

        ResidentServiceResponse answer = residentService.register(residentServicesRequest);

        Resident resident11 = new Resident();
        resident11.setName("Eletu Usman");
        residents.save(resident11);

        assertEquals(2,resident11.getId());
        assertEquals(1,answer.getId());

    }



    @Test
    public void testLogin(){


        ResidentServiceImpl residentService = new ResidentServiceImpl();
        ResidentServicesRequest residentServicesRequest = new ResidentServicesRequest();
        residentServicesRequest.setFullName("Eletu Usman");
        residentServicesRequest.setEmail("@yahho.com");
        residentServicesRequest.setPhonenumber("09134969393");
        residentServicesRequest.setPassword("1235");
        residentService.register(residentServicesRequest);
        ResidentServicesRequest residentServicesRequest1 = new ResidentServicesRequest();
        residentServicesRequest1.setFullName("Eletu Usman");
        residentServicesRequest1.setEmail("yiwqda@yahho.com");
        residentServicesRequest1.setPhonenumber("09134969393");
        residentServicesRequest1.setPassword("twrsq");
        ResidentServiceResponse Step_result= residentService.register(residentServicesRequest1);
        Resident result = new Resident();
        result.setPassword(Step_result.getPassword());
        result.setPhoneNumber(Step_result.getPhoneNumber());
        result.setEmail(Step_result.getEmail());
        result.setName(Step_result.getFullName());


        assertEquals(result,residentService.login("yiwqda@yahho.com","twrsq"));






    }



}

