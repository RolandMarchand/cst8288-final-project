/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.vehicle.makevehicle;

import com.business.contract.controller.VehicleRegistrationMediator;

import com.business.contract.vehicle.vehicleparts.TrainPartsContract;
import com.business.vehicle.gpsimpl.VehicleSimulator;

/**
 * Builds and configures HybridTrain instances using data from the registration mediator.
 * 
 * This builder handles setting up the train's technical details, parts, and maintenance info.
 * 
 * @author D. Santos
 */
public class HybridTrainBuilder extends HybridTrain {

    TrainPartsContract trainPartsContract;
    HybridTrainMaintenanceSchedule hybridTrainMaintenanceSchedule;
    VehicleRegistrationMediator mediatorEvent;
    VehicleSimulator vehicleSimulator;

    public HybridTrainBuilder(VehicleRegistrationMediator mediatorEvent, TrainPartsContract trainPartsContract, HybridTrainMaintenanceSchedule hybridTrainMaintenanceSchedule, VehicleSimulator vehicleSimulator) {
        super(trainPartsContract, hybridTrainMaintenanceSchedule, vehicleSimulator);
    }

    public HybridTrain buildHybridTrain(VehicleRegistrationMediator mediatorevent, TrainPartsContract trainPartsContract, HybridTrainMaintenanceSchedule hybridTrainMaintenanceSchedule) {
        String vehicle = mediatorevent.vehicleType;
        String fuelEnergyType = mediatorevent.fuelEnergyType;
        String vehicleRegistrationNumber = mediatorevent.vehicleRegistrationNumber;
        String consumptionRate = mediatorevent.consumptionRate;
        String maxPassengers = mediatorevent.maxPassengers;
        String currentAssignedRoute = mediatorevent.currentAssignedRoute;

        HybridTrain hybridTrain = new HybridTrain(trainPartsContract, hybridTrainMaintenanceSchedule, vehicleSimulator);

        hybridTrain.setTrainParts(trainPartsContract);
        hybridTrain.setMaintenanceSchedule(hybridTrainMaintenanceSchedule);
        hybridTrain.setConsumptionRate(consumptionRate);
        hybridTrain.setCurrentAssignedRoute(currentAssignedRoute);
        hybridTrain.setFuelEnergyType(fuelEnergyType);
        hybridTrain.setMaxPassengerCount(maxPassengers);
        hybridTrain.setVehicleRegistrationNumber(vehicleRegistrationNumber);
        return hybridTrain;
    }
}
