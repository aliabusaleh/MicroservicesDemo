package com.example.demo.bootstrap;


import com.example.demo.Model.Ride;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Bootstrapbean implements CommandLineRunner {
    public List<Ride> rides;

    @Override
    public void run(String... args) throws Exception {
        rides = null;
    }
}
