package com.business.vehicle.makevehicle;

import com.business.contract.vehicle.makeVehicle.ElectricTrainContract;
import com.business.contract.vehicle.vehicleparts.TrainPartsContract;
import com.business.vehicle.gpsimpl.VehicleSimulator;

/**
 * This class represents an electric train and holds details such as its
 * registration, energy type, passenger capacity, route, and associated parts.
 * 
 * It also links to a maintenance schedule and a vehicle simulator.
 * 
 * @author: D. Santos
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

    /**
     * Creates a new ElectricTrain with the provided parts, maintenance schedule,
     * and simulator.
     *
     * @param trainParts the parts associated with the train
     * @param electricTrainMaintenanceSchedule the train's maintenance schedule
     * @param vehicleSimulator the GPS simulator for the train
     */
    public ElectricTrain(TrainPartsContract trainParts, ElectricTrainMaintenanceSchedule electricTrainMaintenanceSchedule, VehicleSimulator vehicleSimulator) {
    }

    /**
     * Gets the type of energy used by the train.
     *
     * @return the energy/fuel type
     */
    @Override
    public String getFuelEnergyType() {
        return this.fuelEnergyType;
    }

    /**
     * Gets the train's registration number.
     *
     * @return the registration number
     */
    @Override
    public String getVehicleRegistrationNumber() {
        return this.vehicleRegistrationNumber;
    }

    /**
     * Gets the train's consumption rate.
     *
     * @return the energy consumption rate
     */
    @Override
    public String getConsumptionRate() {
        return this.consumptionRate;
    }

    /**
     * Gets the maximum number of passengers the train can carry.
     *
     * @return the passenger count
     */
    @Override
    public String getMaxPassengerCount() {
        return this.maxPassengers;
    }

    /**
     * Gets the current route assigned to the train.
     *
     * @return the assigned route
     */
    @Override
    public String getCurrentAssignedRoute() {
        return this.currentAssignedRoute;
    }

    /**
     * Gets the current train parts assigned to this train.
     *
     * @return the train parts contract
     */
    public TrainPartsContract getCurrentTrainPartsContract() {
        return this.trainPartsContract;
    }

    /**
     * Sets the type of energy used by the train.
     *
     * @param fuelEnergy the energy/fuel type
     */
    @Override
    public void setFuelEnergyType(String fuelEnergy) {
        this.fuelEnergyType = fuelEnergy;
    }

    /**
     * Sets the train's registration number.
     *
     * @param vehicleRegistrationNumber the registration number
     */
    @Override
    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    /**
     * Sets the train's consumption rate.
     *
     * @param consumptionRate the energy consumption rate
     */
    @Override
    public void setConsumptionRate(String consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    /**
     * Sets the train's passenger capacity.
     *
     * @param maxPassengers the number of passengers
     */
    @Override
    public void setMaxPassengerCount(String maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    /**
     * Sets the train's current assigned route.
     *
     * @param currentAssignedRoute the route the train is assigned to
     */
    @Override
    public void setCurrentAssignedRoute(String currentAssignedRoute) {
        this.currentAssignedRoute = currentAssignedRoute;
    }

    /**
     * Sets the maintenance schedule for the train.
     *
     * @param electricTrainMaintenanceSchedule the train's maintenance schedule
     */
    public void setMaintenanceSchedule(ElectricTrainMaintenanceSchedule electricTrainMaintenanceSchedule) {
        this.electricTrainMaintenanceSchedule = electricTrainMaintenanceSchedule;
    }

    /**
     * Sets the train parts for the train.
     *
     * @param trainparts the train parts to assign
     */
    public void setTrainParts(TrainPartsContract trainparts) {
        this.trainPartsContract = trainparts;
    }
}
