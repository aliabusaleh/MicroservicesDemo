package com.example.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

enum RideStatusValues { NEW, FINISHED, UNDERPROGRESS }

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ride {

     int RideID ;
     int TotalAmount ;
     String RideSrc ;
    String RideDst ;
     RideStatusValues RideStatus ;
     boolean HasDriver ;
    DriverDTO RideDriver ;
    PassengerDTO RidePassenger ;

}
