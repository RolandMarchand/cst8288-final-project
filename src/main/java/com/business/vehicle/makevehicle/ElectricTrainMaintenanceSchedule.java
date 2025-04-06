
package com.business.vehicle.makevehicle;

import com.business.contract.vehicle.maintenance.DieselBusMaintenanceScheduleContract;
/**
 *
 * @author D. Santos
 */
public class ElectricTrainMaintenanceSchedule extends ElectricTrainMaintenanceScheduleContract {

    private String brakesMaintenanceKM;
    private String tiresMaintenanceKM;
    private String busAxleBearingAMaintenanceKM;
    private String busAxleBearingBMaintenanceKM;
    private String brakesNextMaintenanceDate;
    private String brakesLastMaintenanceDate;
    private String tiresNextMaintenanceDate;
    private String tiresLastMaintenanceDate;
    private String busAxleBearingANextMaintenanceDate;
    private String busAxleBearingALastMaintenanceDate;
    private String busAxleBearingBNextMaintenanceDate;
    private String busAxleBearingBLastMaintenanceDate;
    private String nextServiceOverhaulDate;
    private String lastServiceOverhaulDate;
    private boolean alertMaintenance;

    ElectricTrainMaintenanceSchedule() {}
    
    //get kilometre wear and tear per part.
    @Override
    public  String getBrakeMaintenanceKM(){
        return brakesMaintenanceKM;
    }

    @Override
    public  String getTiresMaintenanceKM(){
        return tiresMaintenanceKM;
    }

    @Override
    public  String getAxleBearingAMaintenanceKM(){
        return busAxleBearingAMaintenanceKM;
    }

    @Override
    public  String getAxleBearingBMaintenanceKM(){
        return busAxleBearingBMaintenanceKM;
    }

    //set kilometre wear and tear per part.
    @Override
    public  void setBrakeMaintenanceKM(String brakeMaintenanceKM){
        this.brakesMaintenanceKM = brakeMaintenanceKM;
    }

    @Override
    public  void setTiresMaintenanceKM(String tiresMaintenanceKM){
        this.tiresMaintenanceKM = tiresMaintenanceKM;
    }

    @Override
    public  void setAxleBearingAMaintenanceKM(String axleAMaintenanceKM){
        this.busAxleBearingAMaintenanceKM = axleAMaintenanceKM;
    }

    @Override
    public  void setAxleBearingBMaintenanceKM(String axleBMaintenanceKM){
        this.busAxleBearingBMaintenanceKM = axleBMaintenanceKM;
    }

    //get parts next maintenance date
    @Override
    public  String getBrakesNextMaintenanceDate(){
        return brakesNextMaintenanceDate;
    }

    @Override
    public  String getTiresNextMaintenanceDate(){
        return tiresNextMaintenanceDate;
    }

    @Override
    public  String getAxleBearingANextMaintenanceDate(){
        return busAxleBearingANextMaintenanceDate;
    }

    @Override
    public  String getAxleBearingBNextMaintenanceDate(){
        return busAxleBearingBNextMaintenanceDate;
    }

    //set parts next maintenance date. 
    @Override
    public  void setBrakesNextMaintenanceDate(String brakesNextMaintenanceDate){
        this.brakesNextMaintenanceDate = brakesNextMaintenanceDate;
    }

    @Override
    public  void setTiresNextMaintenanceDate(String tiresNextMaintenanceDate){
        this.tiresNextMaintenanceDate = tiresNextMaintenanceDate;
    }

    @Override
    public  void setAxleBearingANextMaintenanceDate(String busAxleBearingANextMaintenanceDate){
        this.busAxleBearingANextMaintenanceDate = busAxleBearingANextMaintenanceDate;
    }

    @Override
    public  void setAxleBearingBNextMaintenanceDate(String busAxleBearingBNextMaintenanceDate){
        this.busAxleBearingBNextMaintenanceDate = busAxleBearingBNextMaintenanceDate;
    }

    //get parts last maintenance date.
    @Override
    public  String getBrakesLastMaintenanceDate(){
        return brakesLastMaintenanceDate;
    }

    @Override
    public  String getTiresLastMaintenanceDate(){
        return tiresLastMaintenanceDate;
    }

    @Override
    public  String getAxleBearingALastMaintenanceDate(){
        return busAxleBearingALastMaintenanceDate;
    }

    @Override
    public  String getAxleBearingBLastMaintenanceDate(){
        return busAxleBearingBLastMaintenanceDate;
    }

    //set parts last maintenance date
    @Override
    public  void setBrakesLastMaintenanceDate(String brakesLastMaintenanceDate){
        this.brakesLastMaintenanceDate = brakesLastMaintenanceDate;
    }

    @Override
    public  void setTiresLastMaintenanceDate(String tiresLastMaintenanceDate){
        this.tiresLastMaintenanceDate = tiresLastMaintenanceDate;
    }

    @Override
    public  void setAxleBearingALastMaintenanceDate(String busAxleBearingALastMaintenanceDate){
        this.busAxleBearingALastMaintenanceDate = busAxleBearingALastMaintenanceDate;
    }

    @Override
    public  void setAxleBearingBLastMaintenanceDate(String busAxleBearingBLastMaintenanceDate){
        this.busAxleBearingBLastMaintenanceDate = busAxleBearingBLastMaintenanceDate;
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
