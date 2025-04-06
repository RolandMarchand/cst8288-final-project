
package com.business.vehicle.makevehicle;


import com.business.contract.controller.VehicleRegistrationMediator;
import com.business.contract.vehicle.vehicleparts.BusPartsContract;



/**
 *
 * @author D. Santos
 */
public class VehicleFactory extends VehicleRegistrationMediator  {


    @Override
    public void sendEvent(VehicleRegistrationMediator mediatorEvent) {
        
    }

    @Override
    public void receiveEvent(VehicleRegistrationMediator mediatorEvent) {
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