package com.example.demo.Controller;

import Model.Passenger;
import com.example.demo.PassengerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    PassengerRepo passengerRepo;
    private static final Logger LOG = LoggerFactory.getLogger(PassengerController.class);
    @GetMapping("/all")
    public Collection<Passenger> getAllPassengers(){
        LOG.info("Retriving data of all Passengers");
        return passengerRepo.passengers;
    }
    @GetMapping("/{id}")
    public Collection<Passenger> getPassengerinfo(@PathVariable int id){
        for (Passenger passenger:passengerRepo.passengers) {
            if(passenger.getUserID() == id){
                LOG.info("Retriving data of Passenger"+passenger.getFirstName());
                return Collections.singleton(passenger);

            }
        }
        LOG.error("Not Valid ID of user");
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }
    @PostMapping("/")
    public Passenger addPassenger(@RequestBody Passenger passenger){
        if(passenger != null ){
            passengerRepo.passengers.add(passenger);
            return passenger;
        }
        LOG.error("Incorrect Passenger Object");
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Object Not correct"
        );
    }

}
