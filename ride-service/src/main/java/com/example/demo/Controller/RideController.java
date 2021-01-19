package com.example.demo.Controller;


import com.example.demo.Model.Ride;
import com.example.demo.bootstrap.Bootstrapbean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
@RestController
@RequestMapping("ride")
public class RideController {
    private static final Logger LOG = LoggerFactory.getLogger(RideController.class);
    @Autowired
    Bootstrapbean RideRepo;


    @GetMapping("/all")
    @HystrixCommand(fallbackMethod = "fallbackgetAllRides")
    public List<Ride> getAllRides(){
        return RideRepo.rides;
    }
    public List<Ride> fallbackgetAllRides(){
            LOG.error("Trying to retrieve empty Ride List");
           return null;

    }

    @GetMapping("/{id}")
    public Collection<Ride> getRideinfo(@PathVariable int id){
        for (Ride ride:RideRepo.rides) {
            if(ride.getRideID() == id){
                LOG.info("Retrieving data of Ride"+ride.getRideID());
                return Collections.singleton(ride);

            }
        }
        LOG.error("Not Valid ID of Ride");
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }
}
