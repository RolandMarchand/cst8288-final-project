/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.maintenance;

/**
 * Abstract class for maintenance schedule contract for diesel buses.
 * 
 * This class extends the BusMaintenanceScheduleContract
 * and continues to define abstract methods for diesel-specific implementations.
 * 
 * @author D. Santos
 */
public abstract class DieselBusMaintenanceScheduleContract extends BusMaintenanceScheduleContract {

    public DieselBusMaintenanceScheduleContract() {
    }

    //get kilometre wear and tear per part.
    @Override
    public abstract String getBrakeMaintenanceKM();

    @Override
    public abstract String getTiresMaintenanceKM();

    @Override
    public abstract String getAxleBearingAMaintenanceKM();

    @Override
    public abstract String getAxleBearingBMaintenanceKM();

    //set kilometre wear and tear per part.
    @Override
    public abstract void setBrakeMaintenanceKM(String brakeMaintenanceKM);

    @Override
    public abstract void setTiresMaintenanceKM(String tiresMaintenanceKM);

    @Override
    public abstract void setAxleBearingAMaintenanceKM(String axleAMaintenanceKM);

    @Override
    public abstract void setAxleBearingBMaintenanceKM(String axleBMaintenanceKM);

    //get parts next maintenance date
    @Override
    public abstract String getBrakesNextMaintenanceDate();

    @Override
    public abstract String getTiresNextMaintenanceDate();

    @Override
    public abstract String getAxleBearingANextMaintenanceDate();

    @Override
    public abstract String getAxleBearingBNextMaintenanceDate();

    //set parts next maintenance date. 
    @Override
    public abstract void setBrakesNextMaintenanceDate(String brakesNextMaintenanceDate);

    @Override
    public abstract void setTiresNextMaintenanceDate(String tiresNextMaintenanceDate);

    @Override
    public abstract void setAxleBearingANextMaintenanceDate(String busAxleBearingANextMaintenanceDate);

    @Override
    public abstract void setAxleBearingBNextMaintenanceDate(String busAxleBearingBNextMaintenanceDate);

    //get parts last maintenance date.
    @Override
    public abstract String getBrakesLastMaintenanceDate();

    @Override
    public abstract String getTiresLastMaintenanceDate();

    @Override
    public abstract String getAxleBearingALastMaintenanceDate();

    @Override
    public abstract String getAxleBearingBLastMaintenanceDate();

    //set parts last maintenance date
    @Override
    public abstract void setBrakesLastMaintenanceDate(String brakesLastMaintenanceDate);

    @Override
    public abstract void setTiresLastMaintenanceDate(String tiresLastMaintenanceDate);

    @Override
    public abstract void setAxleBearingALastMaintenanceDate(String busAxleBearingALastMaintenanceDate);

    @Override
    public abstract void setAxleBearingBLastMaintenanceDate(String busAxleBearingBLastMaintenanceDate);

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
