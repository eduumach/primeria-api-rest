package app.car.cap01.service;

import app.car.cap01.domain.TravelRequest;
import app.car.cap01.domain.TravelRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TravelService {

    @Autowired
    TravelRequestRepository travelRequestRepository;

    public TravelRequest saveTravelRequest(TravelRequest travelRequest){
        return travelRequestRepository.save(travelRequest);
    }
}
