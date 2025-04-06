
package com.business.vehicle.makevehicle;

import com.business.contract.vehicle.maintenance.DieselBusMaintenanceScheduleContract;
/**
 *
 * @author D. Santos
 */
public class DieselBusMaintenanceSchedule extends DieselBusMaintenanceScheduleContract {

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

    DieselBusMaintenanceSchedule() {}
    
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

    @Override
    public String getNextServiceOverhaulDate() {
        return nextServiceOverhaulDate;
    }

    @Override
    public void setNextServiceOverhaulDate(String nextServiceOverhaulDate) {
        this.nextServiceOverhaulDate = nextServiceOverhaulDate;
    }

    @Override
    public String getLastServiceOverhaulDate() {
        return lastServiceOverhaulDate;
    }

    @Override
    public void setLastServiceOverhaulDate(String lastServiceOverhaulDate) {
        this.lastServiceOverhaulDate = lastServiceOverhaulDate;
    }
}