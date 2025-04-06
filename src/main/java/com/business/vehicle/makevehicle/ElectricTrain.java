/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.vehicle.makevehicle;

import com.business.contract.vehicle.makeVehicle.ElectricTrainContract;
import com.business.contract.vehicle.vehicleparts.TrainPartsContract;
import com.business.vehicle.gpsimpl.VehicleSimulator;

/**
 *
 * @author D. Santos
 */
public class ElectricTrain extends ElectricTrainContract {

    private String fuelEnergyType;
    private String vehicleRegistrationNumber;
    private String consumptionRate;
    private String maxPassengers;
    private String currentAssignedRoute;
    public TrainPartsContract trainPartsContract;
    public ElectricTrainMaintenanceSchedule electricTrainMaintenanceSchedule;
    public VehicleSimulator vehicleSimulator;

    public ElectricTrain(TrainPartsContract trainParts, ElectricTrainMaintenanceSchedule electricTrainMaintenanceSchedule, VehicleSimulator vehicleSimulator) {
    }

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

    public TrainPartsContract getCurrentTrainPartsContract() {
        return this.trainPartsContract;
    }

    @Override
    public void setFuelEnergyType(String fuelEnergy) {
        this.fuelEnergyType = fuelEnergy;
    }

    @Override
    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    @Override
    public void setConsumptionRate(String consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    @Override
    public void setMaxPassengerCount(String maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public void setCurrentAssignedRoute(String currentAssignedRoute) {
        this.currentAssignedRoute = currentAssignedRoute;
    }

    public void setMaintenanceSchedule(ElectricTrainMaintenanceSchedule electricTrainMaintenanceSchedule) {
        this.electricTrainMaintenanceSchedule = electricTrainMaintenanceSchedule;
    }

    public void setTrainParts(TrainPartsContract trainparts) {
        this.trainPartsContract = trainparts;
    }

}
