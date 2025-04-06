/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.vehicle.makevehicle;

import com.business.contract.controller.VehicleRegistrationMediator;

import com.business.contract.vehicle.vehicleparts.TrainPartsContract;
import com.business.vehicle.gpsimpl.VehicleSimulator;

/**
 *
 * @author D. Santos
 */
public class ElectricTrainBuilder extends ElectricTrain {

    TrainPartsContract trainPartsContract;
    DieselBusMaintenanceSchedule electricTrainMaintenanceSchedule;
    VehicleRegistrationMediator mediatorEvent;
    VehicleSimulator vehicleSimulator;

    public ElectricTrainBuilder(VehicleRegistrationMediator mediatorEvent, TrainPartsContract trainPartsContract, ElectricTrainMaintenanceSchedule electricTrainMaintenanceSchedule, VehicleSimulator vehicleSimulator) {
        super(trainPartsContract, electricTrainMaintenanceSchedule, vehicleSimulator);
    }

    public ElectricTrain buildElectricTrain(VehicleRegistrationMediator mediatorevent, TrainPartsContract trainPartsContract, ElectricTrainMaintenanceSchedule electricTrainMaintenanceSchedule) {
        String vehicle = mediatorevent.vehicleType;
        String fuelEnergyType = mediatorevent.fuelEnergyType;
        String vehicleRegistrationNumber = mediatorevent.vehicleRegistrationNumber;
        String consumptionRate = mediatorevent.consumptionRate;
        String maxPassengers = mediatorevent.maxPassengers;
        String currentAssignedRoute = mediatorevent.currentAssignedRoute;

        ElectricTrain electricTrain = new ElectricTrain(trainPartsContract, electricTrainMaintenanceSchedule, vehicleSimulator);

        electricTrain.setTrainParts(trainPartsContract);
        electricTrain.setMaintenanceSchedule(electricTrainMaintenanceSchedule);
        electricTrain.setConsumptionRate(consumptionRate);
        electricTrain.setCurrentAssignedRoute(currentAssignedRoute);
        electricTrain.setFuelEnergyType(fuelEnergyType);
        electricTrain.setMaxPassengerCount(maxPassengers);
        electricTrain.setVehicleRegistrationNumber(vehicleRegistrationNumber);
        return electricTrain;
    }
}
