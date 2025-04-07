/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.business.contract.controller;

import java.awt.Event;
import java.lang.reflect.Array;
import javax.swing.JButton;

/**
 * Defines a contract for a Mediator that coordinates vehicle registration events.
 * Used in the vehicle registration system to decouple communication between components.
 * 
 * @author D. Satnos
 */
public interface Mediator {

    /**
     * Sends a vehicle registration event to the appropriate business logic component.
     * 
     * @param mediatorEvent the event carrying vehicle registration data
     */
    public void sendEvent(VehicleRegistrationMediator mediatorEvent);
    
    /**
     * Receives and processes an incoming vehicle registration event.
     * 
     * @param mediatorEvent the event received from another component
     */
    public void receiveEvent(VehicleRegistrationMediator mediatorEvent);
    
    /**
     * Coordinates the steps required to process a vehicle registration.
     * 
     * @param mediatorEvent the registration event with necessary data
     * @return a String result or status of the registration process
     */
    public String processVehicleRegistration(VehicleRegistrationMediator mediatorEvent);
    
}
