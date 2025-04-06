/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.vehicle.makevehicle;

import com.business.contract.vehicle.makeVehicle.DieselBusContract;
import com.business.contract.vehicle.vehicleparts.BusPartsContract;
import com.business.vehicle.gpsimpl.GpsSimulator;

/**
 *
 * @author D. Santos
 */
public class DieselBus extends DieselBusContract {
    
    private  String fuelEnergyType;
    private  String vehicleRegistrationNumber;
    private  String consumptionRate;
    private String maxPassengers;
    private String currentAssignedRoute;
    private BusPartsContract busPartsContract;
    private DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule;

    public DieselBus(BusPartsContract busParts, DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule){}
    
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
    
    
    public BusPartsContract getCurrentBusPartsContract() {
        return this.busPartsContract;
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
    public void setConsumptionRate(String consumptionRate ) {
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

   
    public void setMaintenanceSchedule(DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule) {
        this.dieselBusMaintenanceSchedule = dieselBusMaintenanceSchedule;
    }

    
    public void setBusParts(BusPartsContract busparts) {
        this.busPartsContract = busparts;
    }



}
