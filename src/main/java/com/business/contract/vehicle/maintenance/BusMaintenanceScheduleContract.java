/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.maintenance;

/**
 * Abstract contract for managing a bus's maintenance schedule.
 * This includes defining methods for tracking and setting maintenance-related data
 * such as kilometer thresholds, part-specific service dates, and maintenance alerts.
 * 
 * @author D. Santos
 */
abstract class BusMaintenanceScheduleContract {

    //get kilometre wear and tear per part.
    public abstract String getBrakeMaintenanceKM();

    public abstract String getTiresMaintenanceKM();

    public abstract String getAxleBearingAMaintenanceKM();

    public abstract String getAxleBearingBMaintenanceKM();

    //set kilometre wear and tear per part.
    public abstract void setBrakeMaintenanceKM(String brakeMaintenanceKM);

    public abstract void setTiresMaintenanceKM(String tiresMaintenanceKM);

    public abstract void setAxleBearingAMaintenanceKM(String axleAMaintenanceKM);

    public abstract void setAxleBearingBMaintenanceKM(String axleBMaintenanceKM);

    //get parts next maintenance date
    public abstract String getBrakesNextMaintenanceDate();

    public abstract String getTiresNextMaintenanceDate();

    public abstract String getAxleBearingANextMaintenanceDate();

    public abstract String getAxleBearingBNextMaintenanceDate();

    //set parts next maintenance date.     
    public abstract void setBrakesNextMaintenanceDate(String brakesNextMaintenanceDate);

    public abstract void setTiresNextMaintenanceDate(String tiresNextMaintenanceDate);

    public abstract void setAxleBearingANextMaintenanceDate(String busAxleBearingANextMaintenanceDate);

    public abstract void setAxleBearingBNextMaintenanceDate(String busAxleBearingBNextMaintenanceDate);

    //get parts last maintenance date.
    public abstract String getBrakesLastMaintenanceDate();

    public abstract String getTiresLastMaintenanceDate();

    public abstract String getAxleBearingALastMaintenanceDate();

    public abstract String getAxleBearingBLastMaintenanceDate();

    //set parts last maintenance date
    public abstract void setBrakesLastMaintenanceDate(String brakesLastMaintenanceDate);

    public abstract void setTiresLastMaintenanceDate(String tiresLastMaintenanceDate);

    public abstract void setAxleBearingALastMaintenanceDate(String busAxleBearingALastMaintenanceDate);

    public abstract void setAxleBearingBLastMaintenanceDate(String busAxleBearingBLastMaintenanceDate);

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
