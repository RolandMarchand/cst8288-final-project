package com.business.vehicle.makevehicle;

import com.business.contract.vehicle.maintenance.DieselBusMaintenanceScheduleContract;

/**
 * Manages maintenance information for diesel buses including maintenance
 * kilometers, dates, and alerts for components such as brakes,
 * tires, axle bearings, and service overhauls.
 *
 * This class implements getters and setters for component status and
 * maintenance lifecycle tracking.
 *
 * @author: D. Santos
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
    private boolean alertMaintenance;

    /**
     * Default constructor.
     */
    DieselBusMaintenanceSchedule() {
    }

    /**
     * Gets the total kilometers since the last brake maintenance.
     *
     * @return Brake maintenance kilometers as a string.
     */
    @Override
    public String getBrakeMaintenanceKM() {
        return brakesMaintenanceKM;
    }

    /**
     * Gets the total kilometers since the last tire maintenance.
     *
     * @return Tire maintenance kilometers as a string.
     */
    @Override
    public String getTiresMaintenanceKM() {
        return tiresMaintenanceKM;
    }

    /**
     * Gets the total kilometers since the last axle bearing A maintenance.
     *
     * @return Axle bearing A maintenance kilometers as a string.
     */
    @Override
    public String getAxleBearingAMaintenanceKM() {
        return busAxleBearingAMaintenanceKM;
    }

    /**
     * Gets the total kilometers since the last axle bearing B maintenance.
     *
     * @return Axle bearing B maintenance kilometers as a string.
     */
    @Override
    public String getAxleBearingBMaintenanceKM() {
        return busAxleBearingBMaintenanceKM;
    }

    /**
     * Sets the brake maintenance kilometers.
     *
     * @param brakeMaintenanceKM Brake wear and tear in kilometers.
     */
    @Override
    public void setBrakeMaintenanceKM(String brakeMaintenanceKM) {
        this.brakesMaintenanceKM = brakeMaintenanceKM;
    }

    /**
     * Sets the tire maintenance kilometers.
     *
     * @param tiresMaintenanceKM Tire wear and tear in kilometers.
     */
    @Override
    public void setTiresMaintenanceKM(String tiresMaintenanceKM) {
        this.tiresMaintenanceKM = tiresMaintenanceKM;
    }

    /**
     * Sets the axle bearing A maintenance kilometers.
     *
     * @param axleAMaintenanceKM Axle A wear and tear in kilometers.
     */
    @Override
    public void setAxleBearingAMaintenanceKM(String axleAMaintenanceKM) {
        this.busAxleBearingAMaintenanceKM = axleAMaintenanceKM;
    }

    /**
     * Sets the axle bearing B maintenance kilometers.
     *
     * @param axleBMaintenanceKM Axle B wear and tear in kilometers.
     */
    @Override
    public void setAxleBearingBMaintenanceKM(String axleBMaintenanceKM) {
        this.busAxleBearingBMaintenanceKM = axleBMaintenanceKM;
    }

    /**
     * Gets the next scheduled brake maintenance date.
     *
     * @return The date for the next brake maintenance.
     */
    @Override
    public String getBrakesNextMaintenanceDate() {
        return brakesNextMaintenanceDate;
    }

    /**
     * Gets the next scheduled tire maintenance date.
     *
     * @return The date for the next tire maintenance.
     */
    @Override
    public String getTiresNextMaintenanceDate() {
        return tiresNextMaintenanceDate;
    }

    /**
     * Gets the next scheduled axle bearing A maintenance date.
     *
     * @return The date for the next axle bearing A maintenance.
     */
    @Override
    public String getAxleBearingANextMaintenanceDate() {
        return busAxleBearingANextMaintenanceDate;
    }

    /**
     * Gets the next scheduled axle bearing B maintenance date.
     *
     * @return The date for the next axle bearing B maintenance.
     */
    @Override
    public String getAxleBearingBNextMaintenanceDate() {
        return busAxleBearingBNextMaintenanceDate;
    }

    /**
     * Sets the next brake maintenance date.
     *
     * @param brakesNextMaintenanceDate The scheduled date for brake
     * maintenance.
     */
    @Override
    public void setBrakesNextMaintenanceDate(String brakesNextMaintenanceDate) {
        this.brakesNextMaintenanceDate = brakesNextMaintenanceDate;
    }

    /**
     * Sets the next tire maintenance date.
     *
     * @param tiresNextMaintenanceDate The scheduled date for tire maintenance.
     */
    @Override
    public void setTiresNextMaintenanceDate(String tiresNextMaintenanceDate) {
        this.tiresNextMaintenanceDate = tiresNextMaintenanceDate;
    }

    /**
     * Sets the next axle bearing A maintenance date.
     *
     * @param busAxleBearingANextMaintenanceDate The scheduled date for axle A
     * maintenance.
     */
    @Override
    public void setAxleBearingANextMaintenanceDate(String busAxleBearingANextMaintenanceDate) {
        this.busAxleBearingANextMaintenanceDate = busAxleBearingANextMaintenanceDate;
    }

    /**
     * Sets the next axle bearing B maintenance date.
     *
     * @param busAxleBearingBNextMaintenanceDate The scheduled date for axle B
     * maintenance.
     */
    @Override
    public void setAxleBearingBNextMaintenanceDate(String busAxleBearingBNextMaintenanceDate) {
        this.busAxleBearingBNextMaintenanceDate = busAxleBearingBNextMaintenanceDate;
    }

    /**
     * Gets the last completed brake maintenance date.
     *
     * @return The previous date of brake maintenance.
     */
    @Override
    public String getBrakesLastMaintenanceDate() {
        return brakesLastMaintenanceDate;
    }

    /**
     * Gets the last completed tire maintenance date.
     *
     * @return The previous date of tire maintenance.
     */
    @Override
    public String getTiresLastMaintenanceDate() {
        return tiresLastMaintenanceDate;
    }

    /**
     * Gets the last completed axle bearing A maintenance date.
     *
     * @return The previous date of axle A maintenance.
     */
    @Override
    public String getAxleBearingALastMaintenanceDate() {
        return busAxleBearingALastMaintenanceDate;
    }

    /**
     * Gets the last completed axle bearing B maintenance date.
     *
     * @return The previous date of axle B maintenance.
     */
    @Override
    public String getAxleBearingBLastMaintenanceDate() {
        return busAxleBearingBLastMaintenanceDate;
    }

    /**
     * Sets the last brake maintenance date.
     *
     * @param brakesLastMaintenanceDate The date when brake maintenance was last
     * completed.
     */
    @Override
    public void setBrakesLastMaintenanceDate(String brakesLastMaintenanceDate) {
        this.brakesLastMaintenanceDate = brakesLastMaintenanceDate;
    }

    /**
     * Sets the last tire maintenance date.
     *
     * @param tiresLastMaintenanceDate The date when tire maintenance was last
     * completed.
     */
    @Override
    public void setTiresLastMaintenanceDate(String tiresLastMaintenanceDate) {
        this.tiresLastMaintenanceDate = tiresLastMaintenanceDate;
    }

    /**
     * Sets the last axle bearing A maintenance date.
     *
     * @param busAxleBearingALastMaintenanceDate The date when axle A
     * maintenance was last completed.
     */
    @Override
    public void setAxleBearingALastMaintenanceDate(String busAxleBearingALastMaintenanceDate) {
        this.busAxleBearingALastMaintenanceDate = busAxleBearingALastMaintenanceDate;
    }

    /**
     * Sets the last axle bearing B maintenance date.
     *
     * @param busAxleBearingBLastMaintenanceDate The date when axle B
     * maintenance was last completed.
     */
    @Override
    public void setAxleBearingBLastMaintenanceDate(String busAxleBearingBLastMaintenanceDate) {
        this.busAxleBearingBLastMaintenanceDate = busAxleBearingBLastMaintenanceDate;
    }

    /**
     * Gets the scheduled date for the next full service overhaul.
     *
     * @return The date of the next overhaul service.
     */
    @Override
    public String getNextServiceOverhaulDate() {
        return nextServiceOverhaulDate;
    }

    /**
     * Sets the date for the next full service overhaul.
     *
     * @param nextServiceOverhaulDate The planned date for the next overhaul.
     */
    @Override
    public void setNextServiceOverhaulDate(String nextServiceOverhaulDate) {
        this.nextServiceOverhaulDate = nextServiceOverhaulDate;
    }

    /**
     * Gets the date of the last completed full service overhaul.
     *
     * @return The last overhaul service date.
     */
    @Override
    public String getLastServiceOverhaulDate() {
        return lastServiceOverhaulDate;
    }

    /**
     * Sets the date of the last completed full service overhaul.
     *
     * @param LastServiceOverhaulDate The previous overhaul service date.
     */
    @Override
    public void setLastServiceOverhaulDate(String LastServiceOverhaulDate) {
        this.lastServiceOverhaulDate = LastServiceOverhaulDate;
    }

    /**
     * Sends a maintenance alert by setting the internal alert flag.
     */
    @Override
    public void sendMaintenanceAlert() {
        alertMaintenance = true;
    }
}
