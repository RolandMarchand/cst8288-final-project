/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.maintenance;

/**
 *
 * @author davey
 */
abstract class HybridTrainMaintenanceScheduleContract extends TrainMaintenanceScheduleContract {

    final String catenaryMaintenanceKM;
    final String pantographMaintenanceKM;
    final String circuitBreakerMaintenanceKM;
    private String catenaryNextMaintenanceDate;
    private String catenaryLastMaintenanceDate;
    private String pantographNextMaintenanceDate;
    private String pantographLastMaintenanceDate;
    private String circuitBreakerNextMaintenanceDate;
    private String circuitBreakerLastMaintenanceDate;

    HybridTrainMaintenanceScheduleContract(String catenaryMaintenanceKM, String pantographMaintenanceKM, String circuitBreakerMaintenanceKM, String catenaryNextMaintenanceDate, String pantographNextMaintenanceDate, String circuitBreakerNextMaintenanceDate) {
        this.catenaryMaintenanceKM = catenaryMaintenanceKM;
        this.pantographMaintenanceKM = pantographMaintenanceKM;
        this.circuitBreakerMaintenanceKM = circuitBreakerMaintenanceKM;
        this.catenaryNextMaintenanceDate = catenaryNextMaintenanceDate;
        this.pantographNextMaintenanceDate = pantographNextMaintenanceDate;
        this.circuitBreakerNextMaintenanceDate = circuitBreakerNextMaintenanceDate;

    }

    @Override
    public String getCatenaryMaintenaceKM() {
        return this.catenaryMaintenanceKM;
    }

    @Override
    public String getPantographMaintenanceKM() {
        return this.pantographMaintenanceKM;
    }

    @Override
    public String getCircuitBreakersMaintenanceKM() {
        return this.circuitBreakerMaintenanceKM;
    }

    @Override
    public String getCatenaryNextMaintenanceDate() {
        return this.catenaryNextMaintenanceDate;
    }

    @Override
    public void setCatenaryNextMaintenanceDate(String catenaryNextMaintenanceDate) {
        this.catenaryNextMaintenanceDate = catenaryNextMaintenanceDate;
    }
    
    
    @Override
    public String getCatenaryLastMaintenanceDate() {
        return this.catenaryLastMaintenanceDate;
    }

    @Override
    public void setCatenaryLastMaintenanceDate(String catenaryLastMaintenanceDate) {
        this.catenaryLastMaintenanceDate = catenaryLastMaintenanceDate;
    }

    @Override
    public String getPantographNextMaintenanceDate() {
        return this.pantographNextMaintenanceDate;
    }

    @Override
    public void setPantographNextMaintenanceDate(String pantographNextMaintenanceDate) {
        this.pantographNextMaintenanceDate = pantographNextMaintenanceDate;
    }
    
        @Override
    public String getPantographLastMaintenanceDate() {
        return this.pantographLastMaintenanceDate;
    }

    @Override
    public void setPantographLastMaintenanceDate(String pantographLastMaintenanceDate) {
        this.pantographLastMaintenanceDate = pantographLastMaintenanceDate;
    }

    @Override
    public String getCircuitBreakerNextMaintenanceDate() {
        return this.circuitBreakerNextMaintenanceDate;
    }

    @Override
    public void setCircuitBreakerNextMaintenanceDate(String circuitBreakerNextMaintenanceDate) {
        this.circuitBreakerNextMaintenanceDate = circuitBreakerNextMaintenanceDate;
    }

    @Override
    public String getCircuitBreakerLastMaintenanceDate() {
        return this.circuitBreakerLastMaintenanceDate;
    }

    @Override
    public void setCircuitBreakerLastMaintenanceDate(String circuitBreakerLastMaintenanceDate) {
        this.circuitBreakerLastMaintenanceDate = circuitBreakerLastMaintenanceDate;
    }
    
    
}
