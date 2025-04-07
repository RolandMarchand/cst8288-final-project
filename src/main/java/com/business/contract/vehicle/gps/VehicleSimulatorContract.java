/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.gps;

import com.business.contract.controller.Mediator;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Contract interface for simulating various GPS and vehicle-related behaviors.
 * Acts as a mediator in the system and defines the required methods for vehicle
 * activity simulation, such as location tracking, fuel usage, and time
 * synchronization.
 *
 * @author D. Santos
 */
public interface VehicleSimulatorContract extends Mediator {

    public abstract void gpsOverallCoordinator();

    public abstract void simulateVehicleActivity(boolean vehicleRunning);

    public abstract void simulateVehicleLattitude(boolean vehicleRunning);

    public abstract void simulateVehicleLongitude(boolean vehicleRunning);

    public abstract void simulateClockTime();

    public abstract void simulateFuelEnergyLevel(boolean useFuel, double fuelTank);

    public abstract void calculateFuelEfficiency(boolean vehicleRunning, HashMap fuelChart, double fuelConsumptionRate);

    public abstract void sendFuelAlert(boolean vehicleRunning, double fuelEfficiencyPercentage);

}
