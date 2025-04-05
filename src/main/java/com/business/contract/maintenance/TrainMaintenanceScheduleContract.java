/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.maintenance;

/**
 *
 * @author cretaceous74
 */
abstract class TrainMaintenanceScheduleContract {

    abstract String getCatenaryMaintenaceKM();

    abstract String getPantographMaintenanceKM();

    abstract String getCircuitBreakersMaintenanceKM();

    
    
    abstract String getCatenaryNextMaintenanceDate();

    abstract void setCatenaryNextMaintenanceDate(String catenaryNextMaintenanceDate);
    abstract String getCatenaryLastMaintenanceDate();

    abstract void setCatenaryLastMaintenanceDate(String catenaryLastMaintenanceDate);
    
    
    abstract String getPantographNextMaintenanceDate();
    abstract void setPantographNextMaintenanceDate(String pantographNextMaintenanceDate);
    abstract String getPantographLastMaintenanceDate();
    abstract void setPantographLastMaintenanceDate(String pantographLastMaintenanceDate);
    
    
    abstract String getCircuitBreakerNextMaintenanceDate();

    abstract void setCircuitBreakerNextMaintenanceDate(String circuitBreakerNextMaintenanceDate);
    
    abstract String getCircuitBreakerLastMaintenanceDate();

    abstract void setCircuitBreakerLastMaintenanceDate(String circuitBreakerLastMaintenanceDate);
    
    

}
