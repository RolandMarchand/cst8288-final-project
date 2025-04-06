/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.makeVehicle;

import com.business.contract.vehicle.gps.GPSOdometerContract;
import com.business.contract.vehicle.vehicleparts.BusPartsContract;
import com.business.vehicle.gpsimpl.GpsSimulator;

/**
 *
 * @author D. Santos
 */
abstract class VehicleContract extends GpsSimulator {

    public abstract String getFuelEnergyType();

    public abstract String getVehicleRegistrationNumber();

    public abstract String getConsumptionRate();

    public abstract String getMaxPassengerCount();

    public abstract String getCurrentAssignedRoute();
    
    
    public abstract void setFuelEnergyType(String fuelEnergy);

    public abstract void setVehicleRegistrationNumber(String vehicleRegistrationNumber);

    public abstract void setConsumptionRate(String consumptionRate );

    public abstract void setMaxPassengerCount(String maxPassengers);

    public abstract void setCurrentAssignedRoute(String currentAssignedRoute);
    

    


 
}
