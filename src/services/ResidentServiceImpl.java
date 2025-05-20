package services;

import data.models.Resident;
import data.repository.Residents;
import data.repository.ResidentsRepository;
import dto.request.LoginServiceRequest;
import dto.request.ResidentServicesRequest;
import dto.response.ResidentServiceResponse;

import java.util.Objects;

public class ResidentServiceImpl implements ResidentServices{
    private ResidentsRepository residentsRepository = new Residents();
    private LoginServiceRequest loginServiceRequest = new LoginServiceRequest();


    @Override
    public ResidentServiceResponse register(ResidentServicesRequest residentServicesRequest) {
        Resident resident = new Resident();
        resident.setName(residentServicesRequest.getFullName());
        resident.setEmail(residentServicesRequest.getEmail());
        resident.setPhoneNumber(residentServicesRequest.getPhonenumber());
        resident.setPassword(residentServicesRequest.getPassword());

        if (!checkRegistration(residentServicesRequest)) {
            residentsRepository.save(resident);
        ResidentServiceResponse residentServiceResponse = new ResidentServiceResponse();
        residentServiceResponse.setFullName(resident.getName());
        residentServiceResponse.setEmail(resident.getEmail());
        residentServiceResponse.setPhoneNumber(resident.getPhoneNumber());
        residentServiceResponse.setId(resident.getId());

        return residentServiceResponse;
    }
        return null;

    }

    private boolean checkRegistration(ResidentServicesRequest residentServicesRequest){
        Resident resident = new Resident();
        resident.setEmail(residentServicesRequest.getEmail());
        for(Resident resident1:residentsRepository.getResidents()){
            if(resident.getEmail().equals(resident1.getEmail())) return true;
        }
        return false;
    }

    @Override
    public Resident login(String email, String password) {

        loginServiceRequest.setEmail(email);
        loginServiceRequest.setPassword(password);
        for (Resident resident:residentsRepository.getResidents()){
            if(resident.getEmail().equals(loginServiceRequest.getEmail())
                    && resident.checkPassword(loginServiceRequest.getPassword()))

                return resident;
        }

        return null;
    }










}
