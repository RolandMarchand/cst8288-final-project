/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.maintenance;

/**
 *
 * @author davey
 */
abstract class BusMaintenanceScheduleContract {

    abstract String getBrakeMaintenanceKM();

    abstract String getTiresMaintenanceKM();

    abstract String getAxleBearingAMaintenanceKM();

    abstract String getAxleBearingBMaintenanceKM();

    abstract public String getBrakesNextMaintenanceDate();

    abstract protected void setBrakesNextMaintenanceDate(String brakesNextMaintenanceDate);

    abstract public String getBrakesLastMaintenanceDate();

    abstract protected void setBrakesLastMaintenanceDate(String brakesLastMaintenanceDate);

    abstract public String getTiresNextMaintenanceDate();

    abstract protected void setTiresNextMaintenanceDate(String tiresNextMaintenanceDate);

    abstract public String getTiresLastMaintenanceDate();

    abstract protected void setTiresLastMaintenanceDate(String tiresLastMaintenanceDate);

    abstract public String getAxleBearingANextMaintenanceDate();

    abstract protected void setAxleBearingANextMaintenanceDate(String busAxleBearingANextMaintenanceDate);

    abstract public String getAxleBearingALastMaintenanceDate();

    abstract protected void setAxleBearingALastMaintenanceDate(String busAxleBearingALastMaintenanceDate);

    abstract String getAxleBearingBNextMaintenanceDate();

    abstract protected void setAxleBearingBNextMaintenanceDate(String busAxleBearingBNextMaintenanceDate);

    abstract String getAxleBearingBLastMaintenanceDate();

    abstract protected void setAxleBearingBLastMaintenanceDate(String busAxleBearingBLastMaintenanceDate);

    abstract String getNextServiceOverhaulDate();

    abstract protected void setNextServiceOverhaulDate(String nextServiceOverhaulDate);

    abstract String getLastServiceOverhaulDate();

    abstract protected void setLastServiceOverhaulDate(String LastServiceOverhaulDate);

}
