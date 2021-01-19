package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.stream.Collectors;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationService {

    private final static Logger LOG = LoggerFactory.getLogger(ReservationService.class);
    public List<Ride> RideQueue;
    public List<DriverDTO> DriverQueue;//
    public  List<PassengerDTO> PassengerQueue;

    boolean addToRideQueue(Ride ride){
        if(ride!= null){
        RideQueue.add(ride);
        return true;
        }
        LOG.error("Error while adding to Ride Queue");
        return false;
    }

    boolean addToPassengerQueue(PassengerDTO passenger){
        if(passenger!= null){
            PassengerQueue.add(passenger);
            return true;
        }
        LOG.error("Error while adding to Passenger Queue");
        return false;
    }
    boolean addToDriverQueue(DriverDTO driver){
        if(driver!= null){
            DriverQueue.add(driver);
            return true;
        }
        LOG.error("Error while adding to driver Queue");
        return false;
    }
    Ride getRideInfo(int id){
        for (Ride ride:RideQueue) {
            return (Ride) RideQueue.stream().filter(ride1 -> ride1.getRideID() ==id);

        }
        LOG.error("Incorrect Ride ID while getting Ride Info");
        return null;
    }

    boolean StartRide(int id){
        for (Ride ride:RideQueue
             ) {
            if(ride.getRideID() == id){
                ride.setRideStatus(RideStatusValues.UNDERPROGRESS);
                return true;
            }

        }
        return false;
    }
    boolean StopRide(int id){
        for (Ride ride:RideQueue) {
            if(ride.getRideID() == id){
                ride.setRideStatus(RideStatusValues.FINISHED);
                ride.RideDriver.setAvailable(true);
                return true;
            }

        }
        return false;
    }
    boolean deleteFromDriverQueue(int id){
        try {
            DriverQueue.stream().filter(driverDTO -> driverDTO.getUserID() == id).forEach(DriverQueue::remove);
            return true;
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage());
            return false;
        }

    }
    boolean deleteFromPassengerQueue(int id){
        try {
            PassengerQueue.stream().filter(passengerDTO -> passengerDTO.getUserID() == id).forEach(PassengerQueue::remove);
            return true;
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage());
            return false;
        }
    }
    boolean deleteFromRideQueue(int id){
        try {
            RideQueue.stream().filter(ride -> ride.getRideID() == id).forEach(RideQueue::remove);
            return true;
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage());
            return false;
        }
    }
    boolean emptyDriverQueue(){
        return DriverQueue.isEmpty();
    }
    boolean emptyPassengerQueue(){
        return PassengerQueue.isEmpty();
    }
    boolean emptyRideQueue(){
        return RideQueue.isEmpty();
    }

    void matchRide(){
        if (emptyDriverQueue() || emptyRideQueue()) return;
        Ride ride = null;
        for (Ride item : RideQueue)
        {
            if (!item.HasDriver)
            {
                ride = item;
                break;
            }
        }
        if (ride == null) return;

        DriverDTO driver = null;
        for (DriverDTO item : DriverQueue)
        {
            if (item.Available)
            {
                driver = item;
                break;
            }
        }
        if (driver == null) return;
        ride.setRideDriver(driver);
        driver.setAvailable(false);
        ride.setRideStatus(RideStatusValues.UNDERPROGRESS);
       ride.setHasDriver(true);
       return;
    }

    void printPassengerQueue(){
        PassengerQueue.stream().forEach(passengerDTO -> System.out.println(passengerDTO.getFirstName() +" ,"+passengerDTO.getLastName()));

    }
    void printDriverQueue(){
        DriverQueue.stream().forEach(driverDTO -> System.out.println(driverDTO.getFirstName() +" ,"+driverDTO.getLastName()+" ,"+driverDTO.isAvailable()));

    }
    void printRideQueue(){
        RideQueue.stream().filter(ride -> ride.getRideDriver() != null).forEach(ride -> System.out.println(ride.getRidePassenger().getFirstName() +" ,Driver: "+ride.getRideDriver().getFirstName()));
        RideQueue.stream().filter(ride -> ride.getRideDriver() == null).forEach(ride -> System.out.println(ride.getRidePassenger().getFirstName() +" ,NO Driver!"));


    }
}
