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
    
    
    
    abstract String setBrakeMaintenanceKM();
    
    abstract String setTiresMaintenanceKM();
    
    abstract String setAxleBearingsMaintenanceKM();
    
    abstract String setMinimumMaintenanceDate();
    
    abstract String setNextMaintenenanceDate();
    
}
