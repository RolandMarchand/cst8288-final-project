
package com.business.contract;


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

    public DieselBusContract(String fuelType, String vehicleRegistrationNumber, String consumptionRate, String maxPassengers, String currentAssignedRoute) {
        this.fuelEnergyType = fuelType;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
        this.consumptionRate = consumptionRate;
        this.maxPassengers = maxPassengers;
        this.currentAssignedRoute = currentAssignedRoute;
    }

    @Override
    public String getFuelEnergyType(){
    return this.fuelEnergyType;
    }
    
     @Override
    public String getVehicleRegistrationNumber(){
    return this.vehicleRegistrationNumber;
    }
    
     @Override
    public String getConsumptionRate(){
    return this.consumptionRate;
    }
    
     @Override
    public String getMaxPassengerCount(){
    return this.maxPassengers;
    }
    
     @Override
    public String getCurrentAssignedRoute(){
    return this.currentAssignedRoute;
    }
    
 

}
