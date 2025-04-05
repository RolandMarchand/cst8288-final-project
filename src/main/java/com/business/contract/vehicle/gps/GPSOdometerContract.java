/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.gps;

import java.util.HashMap;

/**
 *
 * @author D. Santos
 */
public interface GPSOdometerContract {
    
    abstract void gpsOverallCoordinator();
    
    abstract void reportCoordinates();
    
    abstract void reportVehicleSpeed();
    
    abstract void reportTime();
    
    abstract HashMap simulateVehicleActivity();
    
    abstract HashMap simulateVehicleLattitude();
    
    abstract HashMap simulateVehicleLongitude();
    
    abstract HashMap simulateClockTime();
    
    abstract void simulateFuelEnergyLevel();
    
    abstract void calculateFuelEfficiency();
    
    abstract void calculateEnergyEfficiency();
    
    abstract void sendFuelAlert();
   
}
