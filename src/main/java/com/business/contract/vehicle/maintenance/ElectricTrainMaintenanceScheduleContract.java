/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.maintenance;

/**
 *
 * @author D. Santos
 */
public abstract class ElectricTrainMaintenanceScheduleContract extends TrainMaintenanceScheduleContract {

   public ElectricTrainMaintenanceScheduleContract() {
    }

       //get kilometre wear and tear per part.
    @Override
    public abstract String getCatenaryMaintenaceKM();

    @Override
    public abstract String getPantographMaintenanceKM();

    @Override
    public abstract String getCircuitBreakersMaintenanceKM();

    //set kilometre wear and tear per part.
    @Override
    public abstract void setCatenaryMaintenaceKM(String catenaryMaintenanceKM);

    @Override
    public abstract void setPantographMaintenanceKM(String pantographMaintenanceKM);

    @Override
    public abstract void setCircuitBreakersMaintenanceKM(String circuitBreakerMaintenanceKM);

    //get parts next maintenance date
    @Override
    public abstract String getCatenaryNextMaintenanceDate();

    @Override
    public abstract String getPantographNextMaintenanceDate();

    @Override
    public abstract String getCircuitBreakerNextMaintenanceDate();

    //set parts next maintenance date. 
    @Override
    public abstract void setCatenaryNextMaintenanceDate(String catenaryNextMaintenanceDate);

    @Override
    public abstract void setPantographNextMaintenanceDate(String pantographLastMaintenanceDate);

    @Override
    public abstract void setCircuitBreakerNextMaintenanceDate(String circuitBreakerNextMaintenanceDate);

    //get parts last maintenance date.
    @Override
    public abstract String getCatenaryLastMaintenanceDate();

    @Override
    public abstract String getPantographLastMaintenanceDate();

    @Override
    public abstract String getCircuitBreakerLastMaintenanceDate();

    //set parts last maintenance date
    @Override
    public abstract void setCatenaryLastMaintenanceDate(String catenaryLastMaintenanceDate);

    @Override
    public abstract void setPantographLastMaintenanceDate(String pantographNextMaintenanceDate);

    @Override
    public abstract void setCircuitBreakerLastMaintenanceDate(String circuitBreakerLastMaintenanceDate);
    
     //get next service overhaul dates
    @Override
    public abstract String getNextServiceOverhaulDate();

    //set next service overhaul date.
    @Override
    public abstract void setNextServiceOverhaulDate(String nextServiceOverhaulDate);

    //get last service overhaul date.
    @Override
    public abstract String getLastServiceOverhaulDate();

    //set last service overhaul date.
    @Override
    public abstract void setLastServiceOverhaulDate(String LastServiceOverhaulDate);

    //send maintenance alert
    @Override
    public abstract void sendMaintenanceAlert();
    

}