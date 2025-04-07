/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.vehicleparts;

/**
 * Represents the contract for accessing and modifying the parts of a bus,
 * such as brakes, tires, and axle bearings.
 * 
 * Provides getter and setter methods.
 * 
 * @author D. Santos
 */
public class BusPartsContract {

    String busBrakes;
    String busTires;
    String busAxleBearingA;
    String busAxleBearingB;

    /**
     * Retrieves the brake information for the bus.
     * 
     * @return the brake component or status information
     */
    public String getBrakes() {
        return busBrakes;
    }

    /**
     * Sets the brake information for the bus.
     * 
     * @param busBrakes the brake component or status information
     */
    public void setBrakes(String busBrakes) {
        this.busBrakes = busBrakes;
    }

    /**
     * Retrieves the tire information for the bus.
     * 
     * @return the tire component or status information
     */
    public String getTires() {
        return busTires;
    }

    /**
     * Sets the tire information for the bus.
     * 
     * @param busTires the tire component or status information
     */
    public void setTires(String busTires) {
        this.busTires = busTires;
    }

    /**
     * Retrieves the axle bearing A information for the bus.
     * 
     * @return the axle bearing A component or status information
     */
    public String getBusAxleBearingA() {
        return busAxleBearingA;
    }

    /**
     * Sets the axle bearing A information for the bus.
     * 
     * @param busAxleBearingA the axle bearing A component or status information
     */
    public void setBusAxleBearingA(String busAxleBearingA) {
        this.busAxleBearingA = busAxleBearingA;
    }

    /**
     * Retrieves the axle bearing B information for the bus.
     * 
     * @return the axle bearing B component or status information
     */
    public String getBusAxleBearingB() {
        return busAxleBearingB;
    }

    /**
     * Sets the axle bearing B information for the bus.
     * 
     * @param busAxleBearingB the axle bearing B component or status information
     */
    public void setBusAxleBearingB(String busAxleBearingB) {
        this.busAxleBearingB = busAxleBearingB;
    }

}
