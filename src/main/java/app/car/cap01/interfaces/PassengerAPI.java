package app.car.cap01.interfaces;

import app.car.cap01.domain.Passenger;
import app.car.cap01.domain.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping(path = "/passengers")
public class PassengerAPI {

    @Autowired
    PassengerRepository passengerRepository;

    @GetMapping
    public List<Passenger> listPassenger(){
        return passengerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Passenger findPassenger(@PathVariable("id") Long id){
        return passengerRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Passenger creatPassenger(@RequestBody Passenger passenger){
        return passengerRepository.save(passenger);
    }

    @PutMapping("/{id}")
    public Passenger fullUpdatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger){
        Passenger p = findPassenger(id);
        p.setName(passenger.getName());
        return passengerRepository.save(p);
    }

    @PatchMapping("/{id}")
    public Passenger incrementalUpdatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger){
        Passenger p = findPassenger(id);
        p.setName(Optional.ofNullable(passenger.getName()).orElse(p.getName()));
        return passengerRepository.save(p);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable("id") Long id){
        passengerRepository.delete(findPassenger(id));
    }

}
