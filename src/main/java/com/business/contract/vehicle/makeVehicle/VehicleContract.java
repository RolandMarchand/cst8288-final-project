/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.makeVehicle;

import com.business.contract.vehicle.gps.GPSOdometerContract;
import com.business.vehicle.gpsimpl.GpsSimulator;

/**
 *
 * @author D. Santos
 */
abstract class VehicleContract extends GpsSimulator {

    abstract String getFuelEnergyType();

    abstract String getVehicleRegistrationNumber();

    abstract String getConsumptionRate();

    abstract String getMaxPassengerCount();

    abstract String getCurrentAssignedRoute();

 
}
