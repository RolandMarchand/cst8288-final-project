/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.makeVehicle;

import com.business.contract.vehicle.gps.GPSOdometerContract;

/**
 *
 * @author D. Santos
 */
abstract class VehicleContract implements GPSOdometerContract {

    abstract String getFuelEnergyType();

    abstract String getVehicleRegistrationNumber();

    abstract String getConsumptionRate();

    abstract String getMaxPassengerCount();

    abstract String getCurrentAssignedRoute();

 
}
