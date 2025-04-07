/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.controller;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author drssa
 */
public class VehicleRegistrationMediatorEvent extends MediatorEvent  {
    
    HttpServletRequest request;

    public VehicleRegistrationMediatorEvent(HttpServletRequest request) {
        this.request = request;
    }
    
    
    public HttpServletRequest getRequest(){
        return request;
    }
    
}
