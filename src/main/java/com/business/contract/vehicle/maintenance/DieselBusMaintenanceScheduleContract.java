/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.maintenance;

/**
 *
 * @author D. Santos
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
    private String nextServiceOverhaulDate;
    private String lastServiceOverhaulDate;

    DieselBusMaintenanceScheduleContract(String brakesMaintenanceKM, String tiresMaintenanceKM, String busAxleBearingAMaintenanceKM, String busAxleBearingBMaintenanceKM, String minimumMaintenanceDate, String nextMaintenanceDate, String brakesNextMaintenanceDate, String tiresNextMaintenanceDate, String busAxleBearingANextMaintenanceDate, String busAxleBearingBNextMaintenanceDate) {
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
    public String getAxleBearingBMaintenanceKM() {
        return this.busAxleBearingBMaintenanceKM;
    }

    @Override
    public String getBrakesNextMaintenanceDate() {
        return this.brakesNextMaintenanceDate;
    }

    @Override
    public String getTiresNextMaintenanceDate() {
        return this.tiresNextMaintenanceDate;
    }

    @Override
    public String getAxleBearingANextMaintenanceDate() {
        return this.busAxleBearingANextMaintenanceDate;
    }

    @Override
    public String getAxleBearingBNextMaintenanceDate() {
        return this.busAxleBearingBNextMaintenanceDate;
    }

    @Override
    public void setBrakesNextMaintenanceDate(String brakesNextMaintenanceDate) {
        this.brakesNextMaintenanceDate = brakesNextMaintenanceDate;
    }

    @Override
    public void setBrakesLastMaintenanceDate(String brakesLastMaintenanceDate) {
        this.brakesLastMaintenanceDate = brakesLastMaintenanceDate;
    }

    @Override
    public void setTiresNextMaintenanceDate(String tiresNextMaintenanceDate) {
        this.tiresNextMaintenanceDate = tiresNextMaintenanceDate;
    }

    @Override
    public void setTiresLastMaintenanceDate(String tiresLastMaintenanceDate) {
        this.tiresLastMaintenanceDate = tiresLastMaintenanceDate;
    }

    @Override
    public void setAxleBearingANextMaintenanceDate(String busAxleBearingANextMaintenanceDate) {
        this.busAxleBearingANextMaintenanceDate = busAxleBearingANextMaintenanceDate;
    }

    @Override
    public void setAxleBearingALastMaintenanceDate(String busAxleBearingANextMaintenanceDate) {
        this.busAxleBearingANextMaintenanceDate = busAxleBearingANextMaintenanceDate;
    }

    @Override
    public void setAxleBearingBNextMaintenanceDate(String busAxleBearingBNextMaintenanceDate) {
        this.busAxleBearingBNextMaintenanceDate = busAxleBearingBNextMaintenanceDate;
    }

    @Override
    public void setAxleBearingBLastMaintenanceDate(String busAxleBearingBNextMaintenanceDate) {
        this.busAxleBearingBNextMaintenanceDate = busAxleBearingBNextMaintenanceDate;
    }

    public String getNextServiceOverhaulDate() {
        return nextServiceOverhaulDate;
    }

    public void setNextServiceOverhaulDate(String nextServiceOverhaulDate) {
        this.nextServiceOverhaulDate = nextServiceOverhaulDate;
    }

    public String getLastServiceOverhaulDate() {
        return lastServiceOverhaulDate;
    }

    public void setLastServiceOverhaulDate(String lastServiceOverhaulDate) {
        this.lastServiceOverhaulDate = lastServiceOverhaulDate;
    }

}
