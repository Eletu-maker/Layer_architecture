package services;

import data.models.Resident;
import data.repository.Residents;
import data.repository.ResidentsRepository;
import dto.request.LoginServiceRequest;
import dto.request.ResidentServicesRequest;
import dto.response.LoginServiceResponse;
import dto.response.ResidentServiceResponse;
import utils.Mapper;

import java.util.List;


public class ResidentServiceImpl implements ResidentServices{
    private ResidentsRepository residentsRepository = new Residents();
    private LoginServiceRequest loginServiceRequest = new LoginServiceRequest();


    @Override
    public ResidentServiceResponse register(ResidentServicesRequest residentServicesRequest) {
        Resident resident = Mapper.map(residentServicesRequest);
        if (!checkRegistration(resident)) {
            residentsRepository.save(resident);
        ResidentServiceResponse residentServiceResponse = Mapper.map(resident) ;
        return residentServiceResponse;
    }else {
            throw new  IllegalArgumentException("you already have an account");
        }


    }

    private boolean checkRegistration(Resident resident){

        for(Resident resident1:residentsRepository.getResidents()){
            if(resident.getEmail().equals(resident1.getEmail())) return true;
        }
        return false;
    }

    @Override
    public Resident login(String email, String password) {
        if (emailInDatabase(email)){
            loginServiceRequest.setEmail(email);
            loginServiceRequest.setPassword(password);
            for (Resident resident : residentsRepository.getResidents()) {
                if (resident.getEmail().equals(loginServiceRequest.getEmail())
                        && resident.checkPassword(loginServiceRequest.getPassword()))
                    return resident;
            }
            for (Resident resident : residentsRepository.getResidents()) {
                if (resident.getEmail().equals(loginServiceRequest.getEmail())
                        && !resident.checkPassword(loginServiceRequest.getPassword()))
                    throw new IllegalArgumentException("wrong password");
            }
        }else {
            throw new IllegalArgumentException("Account do not exist");
        }
        return null;
    }

    private boolean emailInDatabase(String email){
        loginServiceRequest.setEmail(email);
        for (Resident resident:residentsRepository.getResidents()){
            if(resident.getEmail().equals(loginServiceRequest.getEmail())) return true;
        }
        return false;

    }



    public List<Resident> getresidentsRepository(){
        return residentsRepository.getResidents();
    }









}
