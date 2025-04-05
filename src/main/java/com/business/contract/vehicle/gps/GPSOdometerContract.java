/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.gps;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 *
 * @author D. Santos
 */
public interface GPSOdometerContract {
    
    public void gpsOverallCoordinator();
    
    public void reportCoordinates();
    
    public void reportVehicleSpeed();
    
    public void reportTime();
    
    public void simulateVehicleActivity();
    
    public void simulateVehicleLattitude();
    
    public void simulateVehicleLongitude();
    
    public void simulateClockTime();
    
    public void simulateFuelEnergyLevel();
    
    public void calculateFuelEfficiency();
    
    public void calculateEnergyEfficiency();
    
    public void sendFuelAlert();
   
}
