/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.vehicle.makevehicle;

import com.business.contract.controller.VehicleRegistrationMediator;
import com.business.contract.vehicle.vehicleparts.BusPartsContract;
import com.business.vehicle.gpsimpl.VehicleSimulator;

/**
 * Builds and initializes a fully configured DieselBus object using data from
 * the VehicleRegistrationMediator and associated bus components.
 *
 * @author D. Santos
 */
public class DieselBusBuilder extends DieselBus {

    /**
     * Bus parts used for constructing the DieselBus
     */
    BusPartsContract busPartsContract;

    /**
     * Maintenance schedule for the DieselBus
     */
    DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule;

    /**
     * Mediator object carrying vehicle registration and configuration details
     */
    VehicleRegistrationMediator mediatorEvent;

    /**
     * Vehicle simulator instance for the DieselBus
     */
    VehicleSimulator vehicleSimulator;

    /**
     * Constructs a builder for DieselBus using required objects.
     *
     * @param mediatorEvent Mediator containing bus registration and specs
     * @param busPartsContract Bus parts to be used
     * @param dieselBusMaintenanceSchedule Maintenance schedule
     * @param vehicleSimulator Simulator instance
     */
    public DieselBusBuilder(VehicleRegistrationMediator mediatorEvent, BusPartsContract busPartsContract, DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule, VehicleSimulator vehicleSimulator) {
        super(busPartsContract, dieselBusMaintenanceSchedule, vehicleSimulator);
        this.busPartsContract = busPartsContract;
        this.dieselBusMaintenanceSchedule = dieselBusMaintenanceSchedule;
        this.mediatorEvent = mediatorEvent;
        this.vehicleSimulator = vehicleSimulator;
    }

    /**
     * Creates and configures a new DieselBus instance using the mediator event
     * data.
     *
     * @param mediatorevent VehicleRegistrationMediator containing vehicle
     * configuration
     * @param busPartsContract Bus parts to be assigned
     * @param dieselBusMaintenanceSchedule Maintenance schedule to apply
     * @return Configured DieselBus object
     */
    public DieselBus buildDieselBus(VehicleRegistrationMediator mediatorevent, BusPartsContract busPartsContract, DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule) {
        String vehicle = mediatorevent.vehicleType;
        String fuelEnergyType = mediatorevent.fuelEnergyType;
        String vehicleRegistrationNumber = mediatorevent.vehicleRegistrationNumber;
        String consumptionRate = mediatorevent.consumptionRate;
        String maxPassengers = mediatorevent.maxPassengers;
        String currentAssignedRoute = mediatorevent.currentAssignedRoute;

        DieselBus dieselBus = new DieselBus(busPartsContract, dieselBusMaintenanceSchedule, vehicleSimulator);

        dieselBus.setBusParts(busPartsContract);
        dieselBus.setMaintenanceSchedule(dieselBusMaintenanceSchedule);
        dieselBus.setConsumptionRate(consumptionRate);
        dieselBus.setCurrentAssignedRoute(currentAssignedRoute);
        dieselBus.setFuelEnergyType(fuelEnergyType);
        dieselBus.setMaxPassengerCount(maxPassengers);
        dieselBus.setVehicleRegistrationNumber(vehicleRegistrationNumber);

        return dieselBus;
    }
}
