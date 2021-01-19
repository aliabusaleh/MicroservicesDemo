package com.example.demo;

import com.example.demo.Model.DriverDTO;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

//@FeignClient(name="driver-service",url="localhost:8030")
@FeignClient(name ="driver-service")
@RibbonClient(name ="driver-service")
@RequestMapping("/driver")
public interface DriverServiceProxy {
    @GetMapping("/all")
    Collection<DriverDTO> getAllDrivers();
    @PostMapping("/")
    DriverDTO addDriver(@RequestBody DriverDTO driver);
}
