/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.maintenance;

/**
 *
 * @author davey
 */
abstract class BusMaintenanceScheduleContract {

    abstract String getBrakeMaintenanceKM();

    abstract String getTiresMaintenanceKM();

    abstract String getAxleBearingAMaintenanceKM();

    abstract String getAxleBearingBMaintenanceKM();

    abstract String getBrakesNextMaintenanceDate();

    abstract String getTiresNextMaintenanceDate();

    abstract String getAxleBearingANextMaintenanceDate();

    abstract String getAxleBearingBNextMaintenanceDate();

}
