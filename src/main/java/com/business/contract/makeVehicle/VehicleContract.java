/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.makeVehicle;

/**
 *
 * @author davey
 */
abstract class VehicleContract {
    
    
    abstract String getFuelEnergyType();
    
    abstract String getVehicleRegistrationNumber();
    
    abstract String getConsumptionRate();
    
    abstract String getMaxPassengerCount();
    
    abstract String getCurrentAssignedRoute();
            
  
}