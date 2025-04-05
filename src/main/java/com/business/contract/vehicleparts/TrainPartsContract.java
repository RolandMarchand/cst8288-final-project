/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicleparts;

/**
 *
 * @author davey
 */
public class TrainPartsContract {

    public String trainCatenary;
    public String trainPantograph;
    public String trainCircuitBreaker;

    public String getCatenary() {
        return trainCatenary;
    }

    public void setTrainCatenary(String trainCatenary) {
        this.trainCatenary = trainCatenary;
    }

    public String getPantograph() {
        return trainPantograph;
    }

    public void getPantograph(String trainPantograph) {
        this.trainPantograph = trainPantograph;
    }

    public String getCircuitBreaker() {
        return trainCircuitBreaker;
    }

    public void getCircuitBreaker(String trainCircuitBreaker) {
        this.trainCircuitBreaker = trainCircuitBreaker;
    }

}
