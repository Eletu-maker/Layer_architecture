package utils;

import data.models.Resident;
import data.repository.Residents;
import dto.request.ResidentServicesRequest;
import dto.response.ResidentServiceResponse;

public  class Mapper {
    public static Resident map(ResidentServicesRequest residentServicesRequest){
        Resident resident = new Resident();
        resident.setName(residentServicesRequest.getFullName());
        resident.setEmail(residentServicesRequest.getEmail());
        resident.setPhoneNumber(residentServicesRequest.getPhonenumber());
        resident.setPassword(residentServicesRequest.getPassword());
        return resident;

    }

    public static ResidentServiceResponse map(Resident resident){
        ResidentServiceResponse residentServiceResponse = new ResidentServiceResponse();
        residentServiceResponse.setFullName(resident.getName());
        residentServiceResponse.setEmail(resident.getEmail());
        residentServiceResponse.setPhoneNumber(resident.getPhoneNumber());
        residentServiceResponse.setId(resident.getId());

        return residentServiceResponse;

    }

}
