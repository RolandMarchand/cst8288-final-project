/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.controller;

import com.business.contract.vehicle.vehicleparts.BusPartsContract;
import com.business.vehicle.makevehicle.VehicleFactory;
import jakarta.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import javax.swing.JButton;


/**
 *
 * @author drssa
 */
public interface VehicleRegistrationMediator implements VehicleRegistrationMediator {

    private static VehicleRegistrationMediator concreteMediator;

    public Window window;
    private ViewClass viewclass;
    public String brakesMaintenanceKM;
    public String brakesMaintenanceKM;
 private String brakesMaintenanceKM;
    private String tiresMaintenanceKM;
    private String busAxleBearingAMaintenanceKM;
    private String busAxleBearingBMaintenanceKM;
    private String brakesNextMaintenanceDate;
    private String brakesLastMaintenanceDate;
    private String tiresNextMaintenanceDate;
    private String tiresLastMaintenanceDate;
    private String busAxleBearingANextMaintenanceDate;
    private String busAxleBearingALastMaintenanceDate;
    private String busAxleBearingBNextMaintenanceDate;
    private String busAxleBearingBLastMaintenanceDate;
    private String nextServiceOverhaulDate;
    private String lastServiceOverhaulDate;
    private VehicleRegistrationMediator() {
    }

    public static VehicleRegistrationMediator getMediatorInstance() {
        if (concreteMediator == null) {
            concreteMediator = new VehicleRegistrationMediator();
            return concreteMediator;
        } else {
            return concreteMediator;
        }
    }
    
    //parse the post request for this?
    private final String vehicleType;
    private final String fuelEnergyType;
    private final String vehicleRegistrationNumber;
    private final String consumptionRate;
    private final String maxPassengers;
    private String currentAssignedRoute;
    private final BusPartsContract busParts;

    /**
     * Register the viewer class instance where the request comes from.
     * @param viewclass 
     */
    /*
    public void setView(ViewClass viewclass) {
        this.viewclass = viewclass;
    }
8*/
    /**
     * Pass the vehicle request to the business logic class for making the vehicle.
     * @param mediatorEvent 
     */
    @Override
    public void notifyReceiver(VehicleRegistrationMediator mediatorEvent) {
        
        VehicleFactory vehicleFactory = new VehicleFactory();
        vehicleFactory.notifyReceiver(mediatorEvent);
        System.out.println("Step 3. Sent package to VehicleFactory.");
    }

    @Override
    public void notifySender(VehicleRegistrationMediator mediatorEvent) {
        this.window.handleIncoming(mediatorEvent);
        System.out.println("Step 7. Sent the mediatorEvent to the window instance.");

    }

}
