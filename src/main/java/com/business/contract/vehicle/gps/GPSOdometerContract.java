/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.gps;

import com.business.contract.controller.Mediator;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 *
 * @author D. Santos
 */
public interface GPSOdometerContract extends Mediator {
    
    abstract void gpsOverallCoordinator();
    

    abstract void simulateVehicleActivity(boolean vehicleRunning);
    
    abstract void simulateVehicleLattitude(boolean vehicleRunning);
    
    abstract void simulateVehicleLongitude(boolean vehicleRunning);
    
    abstract void simulateClockTime();
    
    abstract void simulateFuelEnergyLevel(boolean useFuel, double fuelTank);
    
    abstract void calculateFuelEfficiency(boolean vehicleRunning, HashMap fuelChart, double fuelConsumptionRate);
    

    abstract void sendFuelAlert(boolean vehicleRunning, double fuelEfficiencyPercentage);
   
}
