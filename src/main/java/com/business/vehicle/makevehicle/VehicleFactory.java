package com.business.vehicle.makevehicle;

import com.business.contract.controller.VehicleRegistrationMediator;
import com.business.contract.vehicle.vehicleparts.BusPartsContract;
import com.business.contract.vehicle.vehicleparts.TrainPartsContract;
import com.business.vehicle.gpsimpl.VehicleSimulator;

/**
 *
 * @author D. Santos
 */
public class VehicleFactory extends VehicleRegistrationMediator {

    @Override
    public void sendEvent(VehicleRegistrationMediator mediatorEvent) {

    }

    @Override
    public void receiveEvent(VehicleRegistrationMediator mediatorEvent) {
        incomingVehicleRequest(mediatorEvent);

    }

    public void incomingVehicleRequest(VehicleRegistrationMediator mediatorEvent) {

        var vehicleType2 = (mediatorEvent.vehicleType);

        switch (vehicleType2) {

            case "DIESELBUS": {
                BusPartsContract busPartsContract = new BusPartsContract();
                DieselBusMaintenanceSchedule dieselBusMaintenanceSchedule = new DieselBusMaintenanceSchedule();
                VehicleSimulator vehicleSimulator = new VehicleSimulator();
                DieselBusBuilder dieselBusBuilder = new DieselBusBuilder(mediatorEvent, busPartsContract, dieselBusMaintenanceSchedule, vehicleSimulator);
            }

            case "ELECTRICTRAIN": {
                TrainPartsContract electricTrainPartsContract = new TrainPartsContract();
                ElectricTrainMaintenanceSchedule electricTrainMaintenanceSchedule = new ElectricTrainMaintenanceSchedule();
                VehicleSimulator vehicleSimulator = new VehicleSimulator();
                ElectricTrainBuilder electricTrainBuilder = new ElectricTrainBuilder(mediatorEvent, electricTrainPartsContract, electricTrainMaintenanceSchedule, vehicleSimulator);
            }

            case "HYBRIDTRAIN": {
                TrainPartsContract hybridTrainPartsContract = new TrainPartsContract();
                HybridTrainMaintenanceSchedule hybridTrainMaintenanceSchedule = new HybridTrainMaintenanceSchedule();
                VehicleSimulator vehicleSimulator = new VehicleSimulator();
                HybridTrainBuilder hybridTrainBuilder = new HybridTrainBuilder(mediatorEvent, hybridTrainPartsContract, hybridTrainMaintenanceSchedule, vehicleSimulator);

            }
        }
    }
}
