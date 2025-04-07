package com.business.vehicle.makevehicle;

import com.business.contract.controller.VehicleRegistrationMediator;
import com.business.contract.vehicle.vehicleparts.BusPartsContract;
import com.business.contract.vehicle.vehicleparts.TrainPartsContract;
import com.business.vehicle.gpsimpl.VehicleSimulator;

/**
 * VehicleFactory handles incoming vehicle registration requests and 
 * builds the appropriate vehicle types such as Diesel Buses, Electric Trains, 
 * and Hybrid Trains based on the provided mediator event.
 * 
 * It uses the VehicleRegistrationMediator pattern to manage communication
 * and coordinates the construction of vehicle objects with their 
 * respective parts, maintenance schedules, and simulators.
 * 
 * Author: D. Santos
 */
public class VehicleFactory extends VehicleRegistrationMediator {

    @Override
    public void sendEvent(VehicleRegistrationMediator mediatorEvent) {
        // Optional: Implement logic to broadcast vehicle creation event
    }

    @Override
    public void receiveEvent(VehicleRegistrationMediator mediatorEvent) {
        incomingVehicleRequest(mediatorEvent);
    }

    /**
     * Handles incoming vehicle creation requests by checking the vehicle type 
     * and constructing the corresponding vehicle along with its parts, 
     * maintenance schedule, and simulator.
     *
     * @param mediatorEvent the mediator carrying vehicle registration data
     */
    public void incomingVehicleRequest(VehicleRegistrationMediator mediatorEvent) {

        var vehicleType2 = mediatorEvent.vehicleType;

        switch (vehicleType2) {

            case "DIESELBUS": {
                BusPartsContract busPartsContract = new BusPartsContract();
                DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule = new DieselBusMaintenanceSchedule();
                VehicleSimulator vehicleSimulator = new VehicleSimulator();
                DieselBusBuilder dieselBusBuilder = new DieselBusBuilder(mediatorEvent, busPartsContract, dieselBusMaintenanceSchedule, vehicleSimulator);
                break;
            }

            case "ELECTRICTRAIN": {
                TrainPartsContract electricTrainPartsContract = new TrainPartsContract();
                ElectricTrainMaintenanceSchedule electricTrainMaintenanceSchedule = new ElectricTrainMaintenanceSchedule();
                VehicleSimulator vehicleSimulator = new VehicleSimulator();
                ElectricTrainBuilder electricTrainBuilder = new ElectricTrainBuilder(mediatorEvent, electricTrainPartsContract, electricTrainMaintenanceSchedule, vehicleSimulator);
                break;
            }

            case "HYBRIDTRAIN": {
                TrainPartsContract hybridTrainPartsContract = new TrainPartsContract();
                HybridTrainMaintenanceSchedule hybridTrainMaintenanceSchedule = new HybridTrainMaintenanceSchedule();
                VehicleSimulator vehicleSimulator = new VehicleSimulator();
                HybridTrainBuilder hybridTrainBuilder = new HybridTrainBuilder(mediatorEvent, hybridTrainPartsContract, hybridTrainMaintenanceSchedule, vehicleSimulator);
                break;
            }

            default: {
                // Optional: log or handle unsupported vehicle types
                break;
            }
        }
    }
}
