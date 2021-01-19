package com.example.demo.Controller;


import com.example.Model.Driver;
import com.example.demo.DriverRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    DriverRepo driversRepo;
    private static final Logger LOG = LoggerFactory.getLogger(DriverController.class);
    @GetMapping("/all")
    public Collection<Driver> getAllDrivers(){
        LOG.info("Retriving data of all drivers");
        return driversRepo.drivers;
    }
    @GetMapping("/{id}")
    public Collection<Driver> getDriverinfo(@PathVariable int id){
        for (Driver driver:driversRepo.drivers) {
            if(driver.getUserID() == id){
                LOG.info("Retriving data of driver"+driver.getFirstName());
                return Collections.singleton(driver);

            }
        }
        LOG.error("Not Valid ID of user");
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }
    @PostMapping("/")
    public Driver addDriver(@RequestBody Driver driver){
        if(driver != null ){
            driversRepo.drivers.add(driver);
            return driver;
        }
        LOG.error("Incorrect Driver Object");
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Object Not correct"
        );
    }

}
