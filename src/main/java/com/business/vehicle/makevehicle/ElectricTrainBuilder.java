/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.vehicle.makevehicle;

import com.business.contract.controller.VehicleRegistrationMediator;
import com.business.contract.vehicle.vehicleparts.BusPartsContract;
import com.business.vehicle.gpsimpl.VehicleSimulator;

/**
 *
 * @author D. Santos
 */
public class ElectricTrainBuilder extends DieselBus {

    BusPartsContract busPartsContract;
    DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule; 
    VehicleRegistrationMediator mediatorEvent;
    VehicleSimulator vehicleSimulator;
    
    public ElectricTrainBuilder(VehicleRegistrationMediator mediatorEvent, BusPartsContract busPartsContract, DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule, VehicleSimulator vehicleSimulator) {
        super(busPartsContract, dieselBusMaintenanceSchedule, vehicleSimulator);
    }
    
    public DieselBus buildDieselBus(VehicleRegistrationMediator mediatorevent, BusPartsContract busPartsContract, DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule)  {
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