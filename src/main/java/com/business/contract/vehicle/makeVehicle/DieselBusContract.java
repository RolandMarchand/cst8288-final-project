package com.business.contract.vehicle.makeVehicle;

import com.business.contract.vehicle.gps.GPSBehaviourContract;
import com.business.contract.vehicle.vehicleparts.BusPartsContract;
import com.business.contract.vehicle.vehicleparts.BusPartsContract;

/**
 *
 * @author D. Santos
 */
abstract class DieselBusContract extends VehicleContract {

    private final String fuelEnergyType;
    private final String vehicleRegistrationNumber;
    private final String consumptionRate;
    private final String maxPassengers;
    private String currentAssignedRoute;
    private final BusPartsContract busParts;

    public DieselBusContract(String fuelType, String vehicleRegistrationNumber, String consumptionRate, String maxPassengers, String currentAssignedRoute, BusPartsContract busPartsContract) {
        this.fuelEnergyType = fuelType;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
        this.consumptionRate = consumptionRate;
        this.maxPassengers = maxPassengers;
        this.currentAssignedRoute = currentAssignedRoute;
        this.busParts = busPartsContract;
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

}
