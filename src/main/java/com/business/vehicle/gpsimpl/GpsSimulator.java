/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.vehicle.gpsimpl;

import java.util.HashMap;
import com.business.contract.vehicle.gps.GPSOdometerContract;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;

/**
 *
 * @author D. Santos
 */
public class GpsSimulator implements GPSOdometerContract {

    HashMap vehicleActivity;
    HashMap vehicleLattitude;
    HashMap vehicleLongitude;
    String vehicleClockTime;
    int vehicleFuelLevel;

    public GpsSimulator() {
        simulateVehicleActivity();
        simulateVehicleLattitude();
        simulateVehicleLongitude();

    }

    @Override
    public void gpsOverallCoordinator() {
        System.out.println("test");
    }

    @Override
    public void reportCoordinates() {
    }

    @Override
    public void reportVehicleSpeed() {
    }

    @Override
    public void reportTime() {
    }

    @Override
    public void simulateVehicleActivity() {
        HashMap vehicleActivitySim = new HashMap(100, 0);
        for (int i = 0; i < 100; i++) {
            vehicleActivitySim.put(i, "Driving");
            for (int j = 20; j < 25; j++) {
                vehicleActivitySim.put(i, "Stopped");
                for (int k = 50; k < 80; k++) {
                    vehicleActivitySim.put(i, "Driving");
                }

            }
        }
        this.vehicleActivity = vehicleActivitySim;
    }

    @Override
    public void simulateVehicleLattitude() {
        Random random = new Random();
        HashMap vehicleLattitudeSim = new HashMap(100);
        for (int i = 0; i < 100; i++) {
            vehicleLattitudeSim.put(i,random.doubles(45.1789, 45.5177));

        }
        this.vehicleActivity = vehicleLattitudeSim;
    }

    @Override
    public void simulateVehicleLongitude() {
        Random random = new Random();
        HashMap vehicleLattitudeSim = new HashMap(100);
        for (int i = 0; i < 1; i++) {
            vehicleLattitudeSim.put(i,random.doubles(-76.1658, -75.4078));
        }
        this.vehicleActivity = vehicleLattitudeSim;
    }


  
    @Override
    public void simulateClockTime(){
           String dateTime = (LocalDateTime.now()).toString();
        this.vehicleClockTime = dateTime;
    }

    @Override
    public void simulateFuelEnergyLevel() {
       if (this.vehicleActivity.containsValue("Driving")){
          int fuel = (this.vehicleFuelLevel - 1);
          this.vehicleFuelLevel = fuel;
       } 
       
    }

    @Override
    public void calculateFuelEfficiency() {
    }

    @Override
    public void calculateEnergyEfficiency() {
    }

    @Override
    public void sendFuelAlert() {
    }

}
