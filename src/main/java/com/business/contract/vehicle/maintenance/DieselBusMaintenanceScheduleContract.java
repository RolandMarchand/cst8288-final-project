/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.maintenance;

/**
 *
 * @author D. Santos
 */
public abstract class DieselBusMaintenanceScheduleContract extends BusMaintenanceScheduleContract {


   public DieselBusMaintenanceScheduleContract(){}

   //get kilometre wear and tear per part.
    @Override
    public abstract String getBrakeMaintenanceKM();

    @Override
    public abstract String getTiresMaintenanceKM();

    @Override
    public abstract String getAxleBearingAMaintenanceKM();

    @Override
    public abstract String getAxleBearingBMaintenanceKM();

    
    //get next maintenance dates for parts. 
    @Override
    public abstract String getBrakesNextMaintenanceDate();

    @Override
    public abstract String getTiresNextMaintenanceDate();

    @Override
    public abstract String getAxleBearingANextMaintenanceDate();

    @Override
    public abstract String getAxleBearingBNextMaintenanceDate();
    
    
    
//set next maintenance days for parts.
    @Override
    public abstract void setBrakesNextMaintenanceDate(String brakesNextMaintenanceDate);

    @Override
    public abstract void setBrakesLastMaintenanceDate(String brakesLastMaintenanceDate);

    @Override
    public abstract void setTiresNextMaintenanceDate(String tiresNextMaintenanceDate);

    @Override
    public abstract void setTiresLastMaintenanceDate(String tiresLastMaintenanceDate);

    @Override
    public abstract void setAxleBearingANextMaintenanceDate(String busAxleBearingANextMaintenanceDate);

    
    //set last maintenance days for parts.
    @Override
    public abstract void setAxleBearingALastMaintenanceDate(String busAxleBearingANextMaintenanceDate);

    @Override
    public abstract void setAxleBearingBNextMaintenanceDate(String busAxleBearingBNextMaintenanceDate);

    @Override
    public abstract void setAxleBearingBLastMaintenanceDate(String busAxleBearingBNextMaintenanceDate);
    
    
    //set/get service overhaul.

    @Override
    public abstract String getNextServiceOverhaulDate();

    @Override
    public abstract void setNextServiceOverhaulDate(String nextServiceOverhaulDate);

    @Override
    public abstract String getLastServiceOverhaulDate();

    @Override
    public abstract void setLastServiceOverhaulDate(String lastServiceOverhaulDate);

}
