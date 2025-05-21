package services;


import data.repository.Residents;
import dto.response.ResidentServiceResponse;
import dto.request.ResidentServicesRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResidentServiceImplTest {

    @BeforeEach
    public void setUp(){
      Residents.reset();
    }







    @Test
    public void testResgister(){
        ResidentServiceImpl residentService = new ResidentServiceImpl();
        ResidentServicesRequest residentServicesRequest = new ResidentServicesRequest();
        residentServicesRequest.setFullName("Eletu Usman");
        residentServicesRequest.setEmail("@yahho.com");
        residentServicesRequest.setPhonenumber("09134969393");
        residentService.register(residentServicesRequest);
        assertEquals(1,residentService.getresidentsRepository().size());

    }

    @Test
    public void testCantResgistertwices(){
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

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            residentService.register(residentServicesRequest1);
        });

        assertEquals("you already have an account", exception.getMessage());

        assertEquals(1,residentService.getresidentsRepository().size());

    }

    @Test
    public void testResgiterId(){
        ResidentServiceImpl residentService = new ResidentServiceImpl();
        ResidentServicesRequest residentServicesRequest = new ResidentServicesRequest();
        residentServicesRequest.setFullName("Eletu Usman");
        residentServicesRequest.setEmail("@yahho.com");
        residentServicesRequest.setPhonenumber("09134969393");
        ResidentServiceResponse answer = residentService.register(residentServicesRequest);
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
        residentService.register(residentServicesRequest1);
        assertEquals(residentService.getresidentsRepository().get(1),residentService.login("yiwqda@yahho.com","twrsq"));
    }

/*
    @Test
    public void testLog() {
        ResidentServiceImpl residentService = new ResidentServiceImpl();
        ResidentServicesRequest residentServicesRequest = new ResidentServicesRequest();
        residentServicesRequest.setFullName("Eletu Usman");
        residentServicesRequest.setEmail("yiwqda@yahho.com");
        residentServicesRequest.setPhonenumber("09134969393");
        residentServicesRequest.setPassword("1235");
        residentService.register(residentServicesRequest);
        ResidentServicesRequest residentServicesRequest1 = new ResidentServicesRequest();
        residentServicesRequest1.setFullName("Eletu Usman");
        residentServicesRequest1.setEmail("@yahho.com");
        residentServicesRequest1.setPhonenumber("09134969393");
        residentServicesRequest1.setPassword("twrsq");
        residentService.register(residentServicesRequest1);
        assertFalse(residentService.emailInDatabase("magic@gmail.com"));
    }


 */


    @Test
    public void testLoginWrongPassword(){
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
        residentService.register(residentServicesRequest1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            residentService.login("yiwqda@yahho.com","rwfgsj");
        });

        assertEquals("wrong password", exception.getMessage());

    }




}

