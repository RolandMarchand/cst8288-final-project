/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.controller;

import com.business.contract.vehicle.vehicleparts.BusPartsContract;
import com.business.vehicle.makevehicle.DieselBusMaintenanceSchedule;
import com.business.vehicle.makevehicle.VehicleFactory;

/**
 * This class acts as a mediator to facilitate communication between the
 * presentation layer and the vehicle registration business logic. It stores
 * vehicle-related data and forwards events to the appropriate handler classes.
 * 
 * Implements the singleton pattern to ensure a single shared instance.
 * 
 * @author D. Santos
 */
public class VehicleRegistrationMediator implements Mediator {

    private static VehicleRegistrationMediator concreteMediator;

    public String catenaryMaintenanceKM;
    public String pantographMaintenanceKM;
    public String circuitBreakersMaintenanceKM;
    public String catenaryNextMaintenanceDate;
    public String pantographNextMaintenanceDate;
    public String circuitBreakersNextMaintenanceDate;
    public String catenaryLastMaintenanceDate;
    public String pantographLastMaintenanceDate;
    public String circuitBreakersLastMaintenanceDate;

    public String vehicleType;
    public String fuelEnergyType;
    public String vehicleRegistrationNumber;
    public String consumptionRate;
    public String maxPassengers;
    public String currentAssignedRoute;
    public BusPartsContract busPartsContract;
    public DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule;

    public String brakesMaintenanceKM;
    public String tiresMaintenanceKM;
    public String busAxleBearingAMaintenanceKM;
    public String busAxleBearingBMaintenanceKM;
    public String brakesNextMaintenanceDate;
    public String brakesLastMaintenanceDate;
    public String tiresNextMaintenanceDate;
    public String tiresLastMaintenanceDate;
    public String busAxleBearingANextMaintenanceDate;
    public String busAxleBearingALastMaintenanceDate;
    public String busAxleBearingBNextMaintenanceDate;
    public String busAxleBearingBLastMaintenanceDate;
    public String nextServiceOverhaulDate;
    public String lastServiceOverhaulDate;
    public boolean alertMaintenance;
    public String placeholder1;

    //singleton
    public static VehicleRegistrationMediator getMediatorInstance() {
        if (concreteMediator == null) {
            concreteMediator = new VehicleRegistrationMediator();
            return concreteMediator;
        } else {
            return concreteMediator;
        }
    }

    /**
     * Register the viewer class instance where the request comes from. TODO:
     * Connect points.
     *
     * @param object
     */
    public void setView(String object) {
        this.placeholder1 = object;
    }

    /**
     * Pass the vehicle request to the business logic class for making the
     * vehicle.
     *
     * @param mediatorEvent
     */
    @Override
    public void sendEvent(VehicleRegistrationMediator mediatorEvent) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        vehicleFactory.sendEvent(mediatorEvent);
    }

    @Override
    public void receiveEvent(VehicleRegistrationMediator mediatorEvent) {
        //TODO: Make connection.
        //this.Object.handleIncoming(mediatorEvent);
    }

    //TODO: determine steps for processVehicleRegistration.
    @Override
    public String processVehicleRegistration(VehicleRegistrationMediator mediatorEvent) {
        String object = new String();
        return object;
    }
}
