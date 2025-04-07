/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.controller;

import com.business.contract.vehicle.vehicleparts.BusPartsContract;
import com.business.vehicle.makevehicle.DieselBusMaintenanceSchedule;
import com.business.vehicle.makevehicle.VehicleFactory;
import dataaccess.VehicleDAO;

/**
 *
 * @author drssa
 */
public class VehicleRegistrationMediator implements MediatorContract {

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

    private static VehicleRegistrationMediator vehicleRegistrationMediatorInstance;
    
    private VehicleRegistrationMediator(){
    }
    
    public static VehicleRegistrationMediator getInstance(){
        if (vehicleRegistrationMediatorInstance == null) {
            vehicleRegistrationMediatorInstance = new VehicleRegistrationMediator();
            return vehicleRegistrationMediatorInstance;
        }
        return vehicleRegistrationMediatorInstance;
    }
    
    
    @Override
    public void receiveEvent(MediatorEvent mediatorEvent) {
            sendEvent(mediatorEvent);
    }

    /**
     *
     * @param mediatorEvent
     */
    @Override
    public void sendEvent(MediatorEvent mediatorEvent) {
        VehicleDAO vehicleDao = new VehicleDAO();
        vehicleDao.receiveEvent(mediatorEvent);
    }
    
}
