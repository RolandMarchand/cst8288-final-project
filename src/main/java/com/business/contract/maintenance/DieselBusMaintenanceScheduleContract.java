/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.maintenance;

/**
 *
 * @author davey
 */
abstract class DieselBusMaintenanceScheduleContract extends BusMaintenanceScheduleContract {
    
    final String brakesMaintenanceKM;
    final String tiresMaintenanceKM;
    final String busAxleBearingAMaintenanceKM;
    final String busAxleBearingBMaintenanceKM;
    private String brakesNextMaintenanceDate;
    private String brakesLastMaintenanceDate;
    private String tiresNextMaintenanceDate;
    private String tiresLastMaintenanceDate;
    private String busAxleBearingANextMaintenanceDate;
    private String busAxleBearingALastMaintenanceDate;
    private String busAxleBearingBNextMaintenanceDate;
    private String busAxleBearingBLastMaintenanceDate;
    
    DieselBusMaintenanceScheduleContract(String brakesMaintenanceKM, String tiresMaintenanceKM, String busAxleBearingAMaintenanceKM, String busAxleBearingBMaintenanceKM, String minimumMaintenanceDate, String nextMaintenanceDate, String brakesNextMaintenanceDate, String tiresNextMaintenanceDate,String busAxleBearingANextMaintenanceDate, String busAxleBearingBNextMaintenanceDate) {
        this.brakesMaintenanceKM = brakesMaintenanceKM;
        this.tiresMaintenanceKM = tiresMaintenanceKM;
        this.busAxleBearingAMaintenanceKM = busAxleBearingAMaintenanceKM;
        this.busAxleBearingBMaintenanceKM = busAxleBearingBMaintenanceKM;
        this.brakesNextMaintenanceDate = brakesNextMaintenanceDate;
        this.tiresNextMaintenanceDate = tiresNextMaintenanceDate;
        this.busAxleBearingANextMaintenanceDate = busAxleBearingANextMaintenanceDate;
        this.busAxleBearingBNextMaintenanceDate = busAxleBearingBNextMaintenanceDate;
    }
    
    @Override
    public String getBrakeMaintenanceKM() {
        return this.brakesMaintenanceKM;
    }

    @Override
    public String getTiresMaintenanceKM() {
        return this.tiresMaintenanceKM;
    }

    @Override
    public String getAxleBearingAMaintenanceKM() {
        return this.busAxleBearingAMaintenanceKM;
    }

    @Override
    public String getAxleBearingBMaintenanceKM(){
        return this.busAxleBearingBMaintenanceKM;
    }
    

    @Override
    public String getBrakesNextMaintenanceDate(){
        return this.brakesNextMaintenanceDate;
    }
    
    @Override
    public String getTiresNextMaintenanceDate(){
        return this.tiresNextMaintenanceDate;
    }
 
    
    @Override
    public String getAxleBearingANextMaintenanceDate(){
        return this.busAxleBearingANextMaintenanceDate;
    }
    
    @Override
    public String getAxleBearingBNextMaintenanceDate(){
        return this.busAxleBearingBNextMaintenanceDate;
    }


    private void setbrakesNextMaintenanceDate(String brakesNextMaintenanceDate){
        this.brakesNextMaintenanceDate = brakesNextMaintenanceDate;
    }
    
    private void setbrakesLastMaintenanceDate(String brakesLastMaintenanceDate){
        this.brakesLastMaintenanceDate = brakesLastMaintenanceDate;
    }
    
    private void setTiresNextMaintenanceDate(String tiresNextMaintenanceDate){
        this.tiresNextMaintenanceDate = tiresNextMaintenanceDate;
    }
    
      private void setTiresLastMaintenanceDate(String tiresLastMaintenanceDate){
        this.tiresLastMaintenanceDate = tiresLastMaintenanceDate;
    }
    
    
    private void setAxleBearingANextMaintenanceDate(String busAxleBearingANextMaintenanceDate){
        this.busAxleBearingANextMaintenanceDate = busAxleBearingANextMaintenanceDate;
    }
    
     private void setAxleBearingALastMaintenanceDate(String busAxleBearingANextMaintenanceDate){
        this.busAxleBearingANextMaintenanceDate = busAxleBearingANextMaintenanceDate;
    }
    
      private void setAxleBearingBNextMaintenanceDate(String busAxleBearingBNextMaintenanceDate){
        this.busAxleBearingBNextMaintenanceDate = busAxleBearingBNextMaintenanceDate;
    }
    
     private void setAxleBearingBLastMaintenanceDate(String busAxleBearingBNextMaintenanceDate){
        this.busAxleBearingBNextMaintenanceDate = busAxleBearingBNextMaintenanceDate;
    }
    
    
    
}