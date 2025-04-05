/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.maintenance;

/**
 *
 * @author D. Santos
 */
abstract class TrainMaintenanceScheduleContract {

    abstract String getCatenaryMaintenaceKM();

    abstract String getPantographMaintenanceKM();

    abstract String getCircuitBreakersMaintenanceKM();

    abstract String getCatenaryNextMaintenanceDate();

    abstract protected void setCatenaryNextMaintenanceDate(String catenaryNextMaintenanceDate);

    abstract String getCatenaryLastMaintenanceDate();

    abstract protected void setCatenaryLastMaintenanceDate(String catenaryLastMaintenanceDate);

    abstract String getPantographNextMaintenanceDate();

    abstract protected void setPantographNextMaintenanceDate(String pantographNextMaintenanceDate);

    abstract String getPantographLastMaintenanceDate();

    abstract protected void setPantographLastMaintenanceDate(String pantographLastMaintenanceDate);

    abstract String getCircuitBreakerNextMaintenanceDate();

    abstract protected void setCircuitBreakerNextMaintenanceDate(String circuitBreakerNextMaintenanceDate);

    abstract String getCircuitBreakerLastMaintenanceDate();

    abstract protected void setCircuitBreakerLastMaintenanceDate(String circuitBreakerLastMaintenanceDate);

}
