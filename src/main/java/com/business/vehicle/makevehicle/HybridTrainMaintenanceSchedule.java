package com.business.vehicle.makevehicle;

import com.business.contract.vehicle.maintenance.ElectricTrainMaintenanceScheduleContract;

/**
 *
 * @author D. Santos
 */
public class HybridTrainMaintenanceSchedule extends ElectricTrainMaintenanceScheduleContract {

    private String catenaryMaintenanceKM;
    private String pantographMaintenanceKM;
    private String circuitBreakersMaintenanceKM;
    private String catenaryNextMaintenanceDate;
    private String catenaryLastMaintenanceDate;
    private String pantographNextMaintenanceDate;
    private String pantographLastMaintenanceDate;
    private String circuitBreakersNextMaintenanceDate;
    private String circuitBreakersLastMaintenanceDate;

    private String nextServiceOverhaulDate;
    private String lastServiceOverhaulDate;
    private boolean alertMaintenance;

    HybridTrainMaintenanceSchedule() {
    }

     //get kilometre wear and tear per part.
    @Override
    public String getCatenaryMaintenaceKM(){
        return catenaryMaintenanceKM;
    }

    @Override
    public  String getPantographMaintenanceKM(){
        return pantographMaintenanceKM;
    }

    @Override
    public String getCircuitBreakersMaintenanceKM(){
        return circuitBreakersMaintenanceKM;
    }

    //set kilometre wear and tear per part.
    @Override
    public  void setCatenaryMaintenaceKM(String catenaryMaintenanceKM){
        this.catenaryMaintenanceKM = catenaryMaintenanceKM;
    }

    @Override
    public void setPantographMaintenanceKM(String pantographMaintenanceKM){
        this.pantographMaintenanceKM = pantographMaintenanceKM;
    }

    @Override
    public void setCircuitBreakersMaintenanceKM(String circuitBreakerMaintenanceKM){
        this.circuitBreakersMaintenanceKM = circuitBreakerMaintenanceKM;
    }

    //get parts next maintenance date
    @Override
    public String getCatenaryNextMaintenanceDate(){
        return catenaryNextMaintenanceDate;
    }

    @Override
    public String getPantographNextMaintenanceDate(){
        return pantographNextMaintenanceDate;
    }

    @Override
    public  String getCircuitBreakerNextMaintenanceDate(){
        return circuitBreakersNextMaintenanceDate;
    }

    //set parts next maintenance date. 
    @Override
    public void setCatenaryNextMaintenanceDate(String catenaryNextMaintenanceDate){
        this.catenaryNextMaintenanceDate = catenaryNextMaintenanceDate;
    }

    @Override
    public void setPantographNextMaintenanceDate(String pantographLastMaintenanceDate){
        this.pantographNextMaintenanceDate = pantographLastMaintenanceDate;
    }

    @Override
    public void setCircuitBreakerNextMaintenanceDate(String circuitBreakerNextMaintenanceDate){
        this.circuitBreakersNextMaintenanceDate = circuitBreakerNextMaintenanceDate;
    }

    //get parts last maintenance date.
    @Override
    public String getCatenaryLastMaintenanceDate(){
        return catenaryLastMaintenanceDate;
    }

    @Override
    public  String getPantographLastMaintenanceDate(){
        return pantographLastMaintenanceDate;
    }

    @Override
    public  String getCircuitBreakerLastMaintenanceDate(){
        return circuitBreakersLastMaintenanceDate;
    }

    //set parts last maintenance date
    @Override
    public  void setCatenaryLastMaintenanceDate(String catenaryLastMaintenanceDate){
        this.catenaryLastMaintenanceDate = catenaryLastMaintenanceDate;
    }

    @Override
    public void setPantographLastMaintenanceDate(String pantographLastMaintenanceDate){
        this.pantographLastMaintenanceDate = pantographLastMaintenanceDate;
    }

    @Override
    public  void setCircuitBreakerLastMaintenanceDate(String circuitBreakerLastMaintenanceDate){
        this.circuitBreakersLastMaintenanceDate = circuitBreakerLastMaintenanceDate; 
    }
    
     //get next service overhaul dates
    @Override
    public  String getNextServiceOverhaulDate(){
        return nextServiceOverhaulDate;
    }

    //set next service overhaul date.
    @Override
    public  void setNextServiceOverhaulDate(String nextServiceOverhaulDate){
        this.nextServiceOverhaulDate = nextServiceOverhaulDate;
    }

    //get last service overhaul date.
    @Override
    public  String getLastServiceOverhaulDate(){
        return lastServiceOverhaulDate;
    }

    //set last service overhaul date.
    @Override
    public  void setLastServiceOverhaulDate(String LastServiceOverhaulDate){
        this.lastServiceOverhaulDate = LastServiceOverhaulDate;
    }

    //send maintenance alert
    @Override
    public  void sendMaintenanceAlert(){
        alertMaintenance = true;
    }
    

}