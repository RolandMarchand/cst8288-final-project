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
public class LoginMediatorEvent extends MediatorEvent {
    
    HttpServletRequest request;
    
    public LoginMediatorEvent(HttpServletRequest request){
    this.request = request;
    }
    
}
