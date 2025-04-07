/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.launcher;

import com.business.contract.vehicle.routes.TransitRouteBuilder;
import java.io.IOException;

/**
 * The launcher class serves as the entry point of the application.
 * It initializes and triggers the loading of transit routes using 
 * the TransitRouteBuilder class.
 * 
 * Author: drssa
 */
public class launcher {

    /**
     * Main method that starts the program and loads transit routes.
     *
     * @param args Command-line arguments
     * @throws IOException if route loading encounters file read issues
     */
    public static void main(String args[]) throws IOException {
        TransitRouteBuilder transitStop2 = new TransitRouteBuilder();
        transitStop2.loadTransitRoutes();
    }
}
