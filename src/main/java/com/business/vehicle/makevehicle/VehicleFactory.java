/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.vehicle.makevehicle;

import com.business.contract.controller.Mediator;
import com.business.contract.controller.VehicleRegistrationMediator;


import com.business.contract.vehicle.makeVehicle.DieselBusContract;
import com.business.contract.vehicle.vehicleparts.BusPartsContract;



/**
 *
 * @author D. Santos
 */
public class VehicleFactory implements VehicleRegistrationMediator  {


    @Override
    public void notifySender(VehicleRegistrationMediator mediatorEvent) {
        
    }

    @Override
    public void notifyReceiver(VehicleRegistrationMediator mediatorEvent) {
        incomingVehicleRequest(mediatorEvent);
        
    }
    
    public void incomingVehicleRequest(VehicleRegistrationMediator mediatorEvent){
      
        var vehicleType2 = (mediatorEvent.vehicleType);
       
        switch (vehicleType2) {

            case "DIESELBUS": {
                BusPartsContract busPartsContract = new BusPartsContract();
                DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule = new DieselBusMaintenanceSchedule();                DieselBusBuilder dieselBusBuilder = new DieselBusBuilder(mediatorEvent, busPartsContract, dieselBusMaintenanceSchedule);
            }

            case "ELECTIRCTRAIN": {
                 ElectricTrainBuilder electricTrainBuilder = new ElectricTrainBuilder();
            }
            case "HYBRIDTRAIN":{
               HybridTrainBuilder hybridTrainBuilder = new HybridTrainBuilder();
               
            }
        }
    }
}