package data.repository;

import data.models.AccessCode;
import data.models.Resident;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class AccessCodes implements AccessCodesRepository{
    private static  List<AccessCode> accessCodes = new ArrayList<>();
    private static long tokenGenerator = 0;

    public static void reset(){
        accessCodes.clear();
        tokenGenerator = 0;
    }

    @Override
    public long count() {
        return accessCodes.size();
    }

    @Override
    public List<AccessCode> findByCreationDate(String date) {
        return List.of();
    }

    @Override
    public List<AccessCode> findByExpirationDate(String date) {
        return List.of();
    }

    @Override
    public List<AccessCode> findByUseDate(String date) {
        return List.of();
    }

    @Override
    public List<AccessCode> findAll() {
        return accessCodes;
    }

    @Override
    public List<AccessCode> findById(long id) {
        List<AccessCode> result = new ArrayList<>();
        for(AccessCode accessCode:accessCodes){
            if (accessCode.getId() == id){
                result.add(accessCode);
            }
        }

        return result;
    }

    @Override
    public Optional<AccessCode> findByToken(String token) {
        for(AccessCode accessCode:accessCodes){
            if(accessCode.getToken().equals(token)){
                return Optional.of(accessCode);
            }
        }
        return Optional.empty();
    }

    @Override
    public AccessCode save(Resident resident, AccessCode accessCode) {
        accessCode.setId(resident.getId());
        accessCode.setToken(createdToken());
        accessCode.setCreationDate();
        accessCodes.add(accessCode);

        return accessCode;
    }

    private String createdToken(){
        Random random = new Random();
        int number = random.nextInt(9000)+1000;
        StringBuilder token = new StringBuilder();
        token.append("Enter");
        token.append(number);
        return token.toString();
    }


    @Override
    public List<AccessCode> findByResident(Resident resident) {
        List<AccessCode> result = new ArrayList<>();
        for(AccessCode accessCode: accessCodes){
            if(resident.getId() == accessCode.getId()){
                result.add(accessCode);
            }
        }

        return result;
    }

    @Override
    public boolean tokenExist(String token) {
        for(AccessCode accessCode:accessCodes){
            if (accessCode.getToken().equals(token)){
               return true;
            }
        }
        return false;
    }

}
