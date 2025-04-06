/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import javax.swing.JButton;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author drssa
 */
class ConcreteMediator implements Mediator {
    
    private static ConcreteMediator concreteMediator;
    
    public Window window;
    private ConcreteMediator(){}
    
    public static ConcreteMediator getMediatorInstance(){
        if (concreteMediator == null) {
            concreteMediator = new ConcreteMediator();
            return concreteMediator;
        }
        else {
           return concreteMediator;
        }
    }
    
    public void setWindow(Window window){
     this.window = window;   
    }
    
    @Override
    public String processVehicleRegistration(VehicleRegistrationMediator mediatorEvent) {
        
        
    }

    @Override
    public void notifySender(VehicleRegistrationMediator mediatorEvent) {
        this.window.handleIncoming(mediatorEvent);
         System.out.println("Step 7. Sent the mediatorEvent to the window instance.");
        
    }

    @Override
    public void notifyReceiver(VehicleRegistrationMediator mediatorEvent) {
        ColorClass colorClass = new ColorClass();
        colorClass.notifyReceiver(mediatorEvent);
        System.out.println("Step 3. Sent package to ColorClass.");
    }
    
}
