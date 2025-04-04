/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.makeVehicle;

import com.business.contract.vehicleparts.TrainPartsContract;
import java.lang.ProcessBuilder.Redirect.Type;

/**
 *
 * @author davey
 */
abstract class ElectricTrainContract extends VehicleContract {

    private final String fuelEnergyType;
    private final String vehicleRegistrationNumber;
    private final String consumptionRate;
    private final String maxPassengers;
    private String currentAssignedRoute;
    private final TrainPartsContract trainParts;

    public ElectricTrainContract(String fuelType, String vehicleRegistrationNumber, String consumptionRate, String maxPassengers, String currentAssignedRoute, com.business.contract.vehicleparts.TrainPartsContract trainPartsContract) {
        this.fuelEnergyType = fuelType;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
        this.consumptionRate = consumptionRate;
        this.maxPassengers = maxPassengers;
        this.currentAssignedRoute = currentAssignedRoute;
        this.trainParts = trainPartsContract;
    }

    @Override
    public String getFuelEnergyType(){
    return this.fuelEnergyType;
    }
    
     @Override
    public String getVehicleRegistrationNumber(){
    return this.vehicleRegistrationNumber;
    }
    
     @Override
    public String getConsumptionRate(){
    return this.consumptionRate;
    }
    
     @Override
    public String getMaxPassengerCount(){
    return this.maxPassengers;
    }
    
     @Override
    public String getCurrentAssignedRoute(){
    return this.currentAssignedRoute;
    }
    
 

}
