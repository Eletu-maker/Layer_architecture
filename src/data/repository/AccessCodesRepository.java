package data.repository;

import data.models.AccessCode;
import data.models.Resident;

import java.util.List;
import java.util.Optional;

public interface AccessCodesRepository {
    long count();
    List<AccessCode> findByCreationDate(String date);
    List<AccessCode> findByExpirationDate(String date);
    List<AccessCode> findByUseDate(String date);
    List<AccessCode> findAll();
    List<AccessCode> findById(long id);
    Optional<AccessCode> findByToken (String token);
    AccessCode save (Resident resident, AccessCode accessCode);
    List<AccessCode> findByResident (Resident resident);
    boolean tokenExist(String token);
}
