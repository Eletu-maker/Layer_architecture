package data.repository;

import data.models.Resident;

import java.util.List;
import java.util.Optional;

public interface ResidentsRepository {
     long count() ;

 void delete(Resident resident);

    void deleteAllById();

    void deleteById(long id) ;

  boolean existsById(long id) ;
  boolean existResident(String name);
  boolean existResident(Resident resident);
    List<Resident> find(String name);
    Optional<Resident> findById(long id);



    Resident save(Resident resident);
    List<Resident> getResidents();
}
