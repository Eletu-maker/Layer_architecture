package data.repository;

import data.models.AccessCode;
import data.models.Resident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class AccessCodesTest {

    private AccessCodes accessCodes;
  @BeforeEach
    public void Setup(){
      accessCodes = new AccessCodes();
      accessCodes.reset();
  }




  @Test
  public void testAccescodesIsEmpty(){

    assertEquals(0,accessCodes.count());
  }


  @Test
  public void testThatAccesCodeIsTwoCount(){

    AccessCode accessCode = new AccessCode();
    Resident resident = new Resident();
    accessCodes.save(resident,accessCode);
    AccessCode accessCode1 = new AccessCode();
    Resident resident1 = new Resident();
    accessCodes.save(resident1,accessCode1);
    assertEquals(2,accessCodes.count());
  }

  @Test
  public void testThatgetAccesCodebyId(){
    AccessCode accessCode = new AccessCode();
    Resident resident = new Resident();
    accessCodes.save(resident,accessCode);
    int found = accessCodes.findById(resident.getId()).size();
    assertEquals(1,found);

  }

  @Test
  public void testAccesCodeExist(){
    AccessCode accessCode = new AccessCode();
    Resident resident = new Resident();
    accessCodes.save(resident,accessCode);
    assertTrue(accessCodes.tokenExist(accessCode.getToken()));
  }


  @Test
  public void testfindByToken(){
    AccessCode accessCode = new AccessCode();
    Resident resident = new Resident();
    accessCodes.save(resident,accessCode);
    AccessCode accessCode1 = new AccessCode();
    Resident resident1 = new Resident();
    accessCodes.save(resident1,accessCode1);
    AccessCode accessCode2 = new AccessCode();
    Resident resident2 = new Resident();
    accessCodes.save(resident2,accessCode2);
    assertEquals(accessCode1,accessCodes.findByToken(accessCode1.getToken()).get());
  }

  @Test
  public void testfindByResident(){
    AccessCode accessCode = new AccessCode();
    Residents residents = new Residents();
    Resident resident = new Resident();
    residents.save(resident);
    accessCodes.save(resident,accessCode);
    AccessCode accessCode1 = new AccessCode();
    Resident resident1 = new Resident();
    residents.save(resident1);
    accessCodes.save(resident1,accessCode1);
    AccessCode accessCode2 = new AccessCode();
    Resident resident2 = new Resident();
    residents.save(resident2);
    accessCodes.save(resident2,accessCode2);
    AccessCode accessCode3 = new AccessCode();
    accessCodes.save(resident2,accessCode3);
    AccessCode accessCode4 = new AccessCode();
    accessCodes.save(resident2,accessCode4);
    assertEquals(3,accessCodes.findByResident(resident2).size());
  }


  @Test
  public void testThatWeCanGetAllAccessCode(){
    AccessCode accessCode = new AccessCode();
    Residents residents = new Residents();
    Resident resident = new Resident();
    residents.save(resident);
    accessCodes.save(resident,accessCode);
    AccessCode accessCode1 = new AccessCode();
    Resident resident1 = new Resident();
    residents.save(resident1);
    accessCodes.save(resident1,accessCode1);
    AccessCode accessCode2 = new AccessCode();
    Resident resident2 = new Resident();
    residents.save(resident2);
    accessCodes.save(resident2,accessCode2);
    AccessCode accessCode3 = new AccessCode();
    accessCodes.save(resident2,accessCode3);
    AccessCode accessCode4 = new AccessCode();
    accessCodes.save(resident2,accessCode4);
    assertEquals(5,accessCodes.findAll().size());
  }
}