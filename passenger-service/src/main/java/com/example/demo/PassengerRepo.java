package com.example.demo;

import Model.Passenger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PassengerRepo implements CommandLineRunner {
    public List<Passenger> passengers;

    @Override
    public void run(String... args) throws Exception {
        before();
        passengers.add(new Passenger(1,10,"driverali","driverali","driverali","driverali"));
        passengers.add(new Passenger(2,10,"driverali","driverali","driverali","driverali"));
        passengers.add(new Passenger(3,10,"driverali","driverali","driverali","driverali"));
        passengers.add(new Passenger(4,10,"driverali","driverali","driverali","driverali"));
        passengers.add(new Passenger(5,10,"driverali","driverali","driverali","driverali"));
    }

    private void before() {
        passengers= new ArrayList<>();
    }
}
