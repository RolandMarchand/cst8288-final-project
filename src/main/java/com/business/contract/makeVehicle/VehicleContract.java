/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.makeVehicle;

import com.business.contract.gps.GPSBehaviourContract;

/**
 *
 * @author davey
 */
abstract class VehicleContract implements GPSBehaviourContract {

    abstract String getFuelEnergyType();

    abstract String getVehicleRegistrationNumber();

    abstract String getConsumptionRate();

    abstract String getMaxPassengerCount();

    abstract String getCurrentAssignedRoute();

    //TODO: implement GPS coordinate function.
    @Override
    public String sendCoordinates() {

        return null;

    }

}
