/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.vehicle.makevehicle;

import com.business.contract.vehicle.vehicleparts.TrainPartsContract;

/**
 *
 * @author D. Santos
 */
public class ElectricTrain {
    
    
    private final String fuelEnergyType;
    private final String vehicleRegistrationNumber;
    private final String consumptionRate;
    private final String maxPassengers;
    private String currentAssignedRoute;
    private final TrainPartsContract trainParts;

    public ElectricTrainContract(){}

    @Override
    public String getFuelEnergyType() {
        return this.fuelEnergyType;
    }

    @Override
    public String getVehicleRegistrationNumber() {
        return this.vehicleRegistrationNumber;
    }

    @Override
    public String getConsumptionRate() {
        return this.consumptionRate;
    }

    @Override
    public String getMaxPassengerCount() {
        return this.maxPassengers;
    }

    @Override
    public String getCurrentAssignedRoute() {
        return this.currentAssignedRoute;
    }

}

}
