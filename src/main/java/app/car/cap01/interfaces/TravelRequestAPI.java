package app.car.cap01.interfaces;

import app.car.cap01.domain.TravelRequest;
import app.car.cap01.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping(path = "/travelRequests")
public class TravelRequestAPI {

    @Autowired
    TravelService travelService;

    @PostMapping
    public void makeTravelRequest(@RequestBody TravelRequest travelRequest){
        travelService.saveTravelRequest(travelRequest);
    }
}
