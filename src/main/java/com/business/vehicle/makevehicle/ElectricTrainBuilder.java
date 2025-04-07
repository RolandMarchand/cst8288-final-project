/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.vehicle.makevehicle;

import com.business.contract.controller.VehicleRegistrationMediator;
import com.business.contract.vehicle.vehicleparts.TrainPartsContract;
import com.business.vehicle.gpsimpl.VehicleSimulator;

/**
 * Builder class for creating and setting up an ElectricTrain object using
 * values from a VehicleRegistrationMediator.
 * 
 * It assigns basic vehicle info, route, and train parts.
 *
 * @author D. Santos
 */
public class ElectricTrainBuilder extends ElectricTrain {

    TrainPartsContract trainPartsContract;
    DieselBusMaintenanceSchedule electricTrainMaintenanceSchedule;
    VehicleRegistrationMediator mediatorEvent;
    VehicleSimulator vehicleSimulator;

    /**
     * Creates a new ElectricTrainBuilder using provided mediator, parts,
     * maintenance, and simulator.
     *
     * @param mediatorEvent the mediator providing train data
     * @param trainPartsContract the train parts
     * @param electricTrainMaintenanceSchedule the train's maintenance schedule
     * @param vehicleSimulator the GPS simulator
     */
    public ElectricTrainBuilder(VehicleRegistrationMediator mediatorEvent, TrainPartsContract trainPartsContract, ElectricTrainMaintenanceSchedule electricTrainMaintenanceSchedule, VehicleSimulator vehicleSimulator) {
        super(trainPartsContract, electricTrainMaintenanceSchedule, vehicleSimulator);
    }

    /**
     * Builds and returns a fully initialized ElectricTrain object using data
     * from the mediator.
     *
     * @param mediatorevent the mediator providing vehicle info
     * @param trainPartsContract the train parts to assign
     * @param electricTrainMaintenanceSchedule the maintenance schedule to assign
     * @return a fully configured ElectricTrain object
     */
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
