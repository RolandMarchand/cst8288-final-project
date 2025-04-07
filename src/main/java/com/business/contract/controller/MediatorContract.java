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
public interface MediatorContract {

    public abstract void sendEvent(MediatorEvent mediatorEvent);
    
    public abstract void receiveEvent(MediatorEvent mediatorEvent);
    

    
}
