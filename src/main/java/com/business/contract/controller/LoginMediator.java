/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author drssa
 */
public class LoginMediator implements MediatorContract {
    
    private static LoginMediator loginMediatorInstance;
    
    private LoginMediator(){
    }
    
    public static LoginMediator getInstance(){
        if (loginMediatorInstance == null) {
            loginMediatorInstance = new LoginMediator();
            return loginMediatorInstance;
        }
        return loginMediatorInstance;
    }
    
    //TODO: Implement LoginDao.
    @Override
    public void receiveEvent(MediatorEvent mediatorEvent) {
            sendEvent(mediatorEvent);
    }

    /**
     *
     * @param mediatorEvent
     */
    @Override
    public void sendEvent(MediatorEvent mediatorEvent) {
        //LoginDao.receiveEvent(mediatorEvent);
    }
    
}
