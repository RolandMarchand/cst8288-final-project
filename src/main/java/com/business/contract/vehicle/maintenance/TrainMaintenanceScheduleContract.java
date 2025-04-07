/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.maintenance;

/**
 * Abstract base class for defining maintenance schedules of train systems.
 * 
 * This class specifies the methods for retrieving and updating
 * maintenance details of train components such as catenaries, pantographs,
 * and circuit breakers.
 * 
 * @author D. Santos
 */
abstract class TrainMaintenanceScheduleContract {

    //get kilometre wear and tear per part.
    public abstract String getCatenaryMaintenaceKM();

    public abstract String getPantographMaintenanceKM();

    public abstract String getCircuitBreakersMaintenanceKM();

    //set kilometre wear and tear per part.
    public abstract void setCatenaryMaintenaceKM(String catenaryMaintenanceKM);

    public abstract void setPantographMaintenanceKM(String pantographMaintenanceKM);

    public abstract void setCircuitBreakersMaintenanceKM(String circuitBreakerMaintenanceKM);

    //get parts next maintenance date
    public abstract String getCatenaryNextMaintenanceDate();

    public abstract String getPantographNextMaintenanceDate();

    public abstract String getCircuitBreakerNextMaintenanceDate();

    //set parts next maintenance date. 
    public abstract void setCatenaryNextMaintenanceDate(String catenaryNextMaintenanceDate);

    public abstract void setPantographNextMaintenanceDate(String pantographLastMaintenanceDate);

    public abstract void setCircuitBreakerNextMaintenanceDate(String circuitBreakerNextMaintenanceDate);

    //get parts last maintenance date.
    public abstract String getCatenaryLastMaintenanceDate();

    public abstract String getPantographLastMaintenanceDate();

    public abstract String getCircuitBreakerLastMaintenanceDate();

    //set parts last maintenance date
    public abstract void setCatenaryLastMaintenanceDate(String catenaryLastMaintenanceDate);

    public abstract void setPantographLastMaintenanceDate(String pantographNextMaintenanceDate);

    public abstract void setCircuitBreakerLastMaintenanceDate(String circuitBreakerLastMaintenanceDate);
    
    //get next service overhaul dates
    public abstract String getNextServiceOverhaulDate();

    //set next service overhaul date.
    public abstract void setNextServiceOverhaulDate(String nextServiceOverhaulDate);

    //get last service overhaul date.
    public abstract String getLastServiceOverhaulDate();

    //set last service overhaul date.
    public abstract void setLastServiceOverhaulDate(String LastServiceOverhaulDate);

    //send maintenance alert
    public abstract void sendMaintenanceAlert();

}
