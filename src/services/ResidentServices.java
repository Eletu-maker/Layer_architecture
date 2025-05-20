package services;

import data.models.Resident;
import dto.response.ResidentServiceResponse;
import dto.request.ResidentServicesRequest;

public interface ResidentServices {
    ResidentServiceResponse register(ResidentServicesRequest residentServicesRequest);
    Resident login(String email,String password);

}
