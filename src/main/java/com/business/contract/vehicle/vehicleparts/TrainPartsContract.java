/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.vehicleparts;

/**
 * Represents the contract for accessing and modifying the parts of a train,
 * such as catenary systems, pantograph, and circuit breaker.
 * 
 * Provides getter and setter methods.
 * 
 * @author D. Santos
 */
public class TrainPartsContract {

    public String trainCatenary;
    public String trainPantograph;
    public String trainCircuitBreaker;

    /**
     * Retrieves the catenary information.
     * 
     * @return the train catenary data
     */
    public String getCatenary() {
        return trainCatenary;
    }

    /**
     * Sets the catenary information.
     * 
     * @param trainCatenary the catenary data to set
     */
    public void setTrainCatenary(String trainCatenary) {
        this.trainCatenary = trainCatenary;
    }

    /**
     * Retrieves the pantograph information.
     * 
     * @return the train pantograph data
     */
    public String getPantograph() {
        return trainPantograph;
    }

    /**
     * Sets the pantograph information.
     * 
     * @param trainPantograph the pantograph data to set
     */
    public void setPantograph(String trainPantograph) {
        this.trainPantograph = trainPantograph;
    }

    /**
     * Retrieves the circuit breaker information.
     * 
     * @return the train circuit breaker data
     */
    public String getCircuitBreaker() {
        return trainCircuitBreaker;
    }

    /**
     * Sets the circuit breaker information.
     * 
     * @param trainCircuitBreaker the circuit breaker data to set
     */
    public void setCircuitBreaker(String trainCircuitBreaker) {
        this.trainCircuitBreaker = trainCircuitBreaker;
    }
}
