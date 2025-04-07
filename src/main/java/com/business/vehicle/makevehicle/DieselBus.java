/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.vehicle.makevehicle;

import com.business.contract.vehicle.makeVehicle.DieselBusContract;
import com.business.contract.vehicle.vehicleparts.BusPartsContract;
import com.business.vehicle.gpsimpl.VehicleSimulator;

/**
 * Represents a Diesel Bus implementation that includes fuel type, registration
 * details, route assignment, passenger capacity, maintenance scheduling, and
 * vehicle simulation capabilities.
 *
 * @author D. Santos
 */
public class DieselBus extends DieselBusContract {

    private String fuelEnergyType;
    private String vehicleRegistrationNumber;
    private String consumptionRate;
    private String maxPassengers;
    private String currentAssignedRoute;

    /**
     * Bus parts associated with this diesel bus
     */
    public BusPartsContract busPartsContract;

    /**
     * Maintenance schedule specific to this diesel bus
     */
    public DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule;

    /**
     * Vehicle simulator instance for simulating movement and fuel use
     */
    public VehicleSimulator vehicleSimulator;

    /**
     * Constructs a DieselBus instance with required components.
     *
     * @param busParts Bus parts for this diesel bus
     * @param dieselBusMaintenanceSchedule Maintenance schedule for this diesel
     * bus
     * @param vehicleSimulator Simulator for vehicle behavior
     */
    public DieselBus(BusPartsContract busParts, DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule, VehicleSimulator vehicleSimulator) {
        this.busPartsContract = busParts;
        this.dieselBusMaintenanceSchedule = dieselBusMaintenanceSchedule;
        this.vehicleSimulator = vehicleSimulator;
    }

    /**
     * @return the fuel energy type of the bus
     */
    @Override
    public String getFuelEnergyType() {
        return this.fuelEnergyType;
    }

    /**
     * @return the vehicle's registration number
     */
    @Override
    public String getVehicleRegistrationNumber() {
        return this.vehicleRegistrationNumber;
    }

    /**
     * @return the fuel consumption rate
     */
    @Override
    public String getConsumptionRate() {
        return this.consumptionRate;
    }

    /**
     * @return the maximum number of passengers
     */
    @Override
    public String getMaxPassengerCount() {
        return this.maxPassengers;
    }

    /**
     * @return the route the vehicle is currently assigned to
     */
    @Override
    public String getCurrentAssignedRoute() {
        return this.currentAssignedRoute;
    }

    /**
     * @return the current BusPartsContract instance
     */
    public BusPartsContract getCurrentBusPartsContract() {
        return this.busPartsContract;
    }

    /**
     * @param fuelEnergy Sets the fuel energy type
     */
    @Override
    public void setFuelEnergyType(String fuelEnergy) {
        this.fuelEnergyType = fuelEnergy;
    }

    /**
     * @param vehicleRegistrationNumber Sets the vehicle registration number
     */
    @Override
    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    /**
     * @param consumptionRate Sets the fuel consumption rate
     */
    @Override
    public void setConsumptionRate(String consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    /**
     * @param maxPassengers Sets the maximum number of passengers
     */
    @Override
    public void setMaxPassengerCount(String maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    /**
     * @param currentAssignedRoute Sets the current route assignment
     */
    @Override
    public void setCurrentAssignedRoute(String currentAssignedRoute) {
        this.currentAssignedRoute = currentAssignedRoute;
    }

    /**
     * Sets the maintenance schedule for this diesel bus.
     *
     * @param dieselBusMaintenanceSchedule The maintenance schedule to assign
     */
    public void setMaintenanceSchedule(DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule) {
        this.dieselBusMaintenanceSchedule = dieselBusMaintenanceSchedule;
    }

    /**
     * Sets the parts associated with this diesel bus.
     *
     * @param busparts The parts to assign to the bus
     */
    public void setBusParts(BusPartsContract busparts) {
        this.busPartsContract = busparts;
    }
}
