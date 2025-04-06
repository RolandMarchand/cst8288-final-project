package com.business.contract.vehicle.makeVehicle;

import com.business.contract.vehicle.vehicleparts.BusPartsContract;
import com.business.contract.vehicle.vehicleparts.BusPartsContract;
import com.business.contract.vehicle.gps.VehicleSimulatorContract;

/**
 *
 * @author D. Santos
 */
 public abstract class HybridTrainContract extends VehicleContract {

     @Override
    public abstract String getFuelEnergyType();
    
     @Override
    public abstract String getVehicleRegistrationNumber();

    @Override
    public abstract String getConsumptionRate();

    @Override
    public abstract String getMaxPassengerCount();

    @Override
    public abstract String getCurrentAssignedRoute();
    
    
    @Override
    public abstract void setFuelEnergyType(String fuelEnergy);
    
    @Override
    public abstract void setVehicleRegistrationNumber(String vehicleRegistrationNumber);

    @Override
    public abstract void setConsumptionRate(String consumptionRate );

    @Override
    public abstract void setMaxPassengerCount(String maxPassengers);

    @Override
    public abstract void setCurrentAssignedRoute(String currentAssignedRoute);


    
   
}
