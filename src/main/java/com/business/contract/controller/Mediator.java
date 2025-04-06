/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.business.contract.controller;

import java.awt.Event;
import java.lang.reflect.Array;
import javax.swing.JButton;

/**
 *
 * @author drssa
 */
public interface Mediator {

    public  void notifySender(VehicleRegistrationMediator mediatorEvent);
    
    public void notifyReceiver(VehicleRegistrationMediator mediatorEvent);
    
    
}
