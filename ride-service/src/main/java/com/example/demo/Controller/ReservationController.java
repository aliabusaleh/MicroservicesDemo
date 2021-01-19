package com.example.demo.Controller;


import com.example.demo.DriverServiceProxy;
import com.example.demo.Model.DriverDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private static Logger LOG = LoggerFactory.getLogger(RestController.class);
    @Autowired
    private DriverServiceProxy proxy;

    @GetMapping("/drivers")
    @HystrixCommand(fallbackMethod = "fallbackgetAllDrivers")
    public Collection<DriverDTO> getAllDrivers(){
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );

     //   return proxy.getAllDrivers();
    }

    public Collection<DriverDTO> fallbackgetAllDrivers(){
        LOG.error("Driver service Error!!");
        throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"No Driver service!");
    }

}
