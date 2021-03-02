package app.car.cap01.interfaces;

import app.car.cap01.domain.Driver;
import app.car.cap01.domain.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverAPI {

    @Autowired
    DriverRepository driverRepository;

    @GetMapping("/drivers")
    public List<Driver> listDrivers(){
        return driverRepository.findAll();
    }

    @GetMapping("/drivers/{id}")
    public Driver findDriver(@PathVariable("id") Long id){
        return driverRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/drivers")
    public Driver createDriver(@RequestBody Driver driver){
        return driverRepository.save(driver);
    }

    @PutMapping("/drivers/{id}")
    public Driver fullUpdateDriver(@PathVariable("id") Long id, @RequestBody Driver driver){
        Driver foundDriver = findDriver(id);
        foundDriver.setBirthData(driver.getBirthData());
        foundDriver.setName(driver.getName());
        return driverRepository.save(foundDriver);
    }

    @PatchMapping("/drivers/{id}")
    public  Driver incrementalUpdateDriver(@PathVariable("id") Long id, @RequestBody Driver driver){
        Driver foundDriver = findDriver(id);
        foundDriver.setBirthData(Optional.ofNullable(driver.getBirthData()).orElse(foundDriver.getBirthData()));
        foundDriver.setName(Optional.ofNullable(driver.getName()).orElse(foundDriver.getName()));
        return driverRepository.save(foundDriver);
    }

}