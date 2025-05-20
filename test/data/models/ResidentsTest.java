package data.models;

import data.repository.Residents;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResidentsTest {
    //Residents residents;
/*
    @BeforeEach
    public void setUp(){
        residents = new Residents();
    }

 */
    @Test
    public void testThatResidentIsZero(){
        Residents residents =  new Residents();
        assertEquals(0,residents.count());
    }

    @Test
    public void testThatResidentIsOneCount(){
        Residents residents =  new Residents();
        Resident resident = new Resident();
        residents.save(resident);
        Resident resident2 = new Resident();
        residents.save(resident2);

        assertEquals(2,residents.count());
    }

    @Test
    public void testThatgetResidentbyId(){
        Residents residents =  new Residents();
        Resident resident = new Resident();
        Resident findResident = resident;
        residents.save(resident);
        Resident found = residents.findById(1).get();
        assertEquals(findResident, found);

    }

    @Test
    public void testFindResidentExist(){
        Residents residents =  new Residents();
        Resident resident1 = new Resident();
        resident1.setName("Hawant rahim");
        residents.save(resident1);
        Resident resident2 = new Resident();
        resident2.setName("Lawal Bode");
        residents.save(resident2);

       assertTrue(residents.existResident("Hawant rahim"));

    }

    @Test
    public void testFindexistingId(){
        Residents residents =  new Residents();
        Resident resident1 = new Resident();
        residents.save(resident1);
        Resident resident2 = new Resident();
        residents.save(resident2);
        Resident resident3 = new Resident();
        residents.save(resident3);
        assertTrue(residents.existsById(3));
    }

    @Test
    public void testFindResidentByName(){
        Residents residents =  new Residents();
        Resident resident1 = new Resident();
        resident1.setName("Hawant rahim");
        residents.save(resident1);
        Resident resident2 = new Resident();
        resident2.setName("Lawal Bode");
        residents.save(resident2);
        Resident resident3 = new Resident();
        resident3.setName("Eric balogun");
        residents.save(resident3);
        assertEquals(1,residents.find("Hawant rahim").size());
    }

    @Test
    public void testUpdate(){
        Residents residents =  new Residents();
        Resident resident1 = new Resident();

        residents.save(resident1);
       
        Resident resident2 = new Resident();

        resident2.setId(resident1.getId());

        residents.save(resident2);



        assertEquals(1,residents.count());






    }



}