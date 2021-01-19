package com.example.demo;

import com.example.Model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DriverRepo implements CommandLineRunner {
    public List<Driver> drivers;

    @Override
    public void run(String... args) throws Exception {
        before();
            drivers.add(new Driver(1,132,true,"ali","ali","ali","ali"));
            drivers.add(new Driver(2,132,true,"ali","ali","ali","ali"));
            drivers.add(new Driver(3,132,true,"ali","ali","ali","ali"));
            drivers.add(new Driver(4,132,true,"ali","ali","ali","ali"));
            drivers.add(new Driver(5,132,true,"ali","ali","ali","ali"));
    }

    private void before() {
        drivers= new ArrayList<>();
    }
}
