package com.business.vehicle.makevehicle;

import com.business.contract.controller.VehicleRegistrationMediator;

/**
 * Builds and initializes HybridTrainMaintenanceSchedule using maintenance data 
 * from the VehicleRegistrationMediator.
 * 
 * This builder sets up all required fields such as wear and tear data and 
 * maintenance scheduling.
 * 
 * @author D. Santos
 */
public class HybridTrainMaintenanceBuilder extends HybridTrainMaintenanceSchedule {

    VehicleRegistrationMediator mediatorEvent;

    public HybridTrainMaintenanceBuilder(VehicleRegistrationMediator mediatorevent) {
    }

    public HybridTrainMaintenanceSchedule buildHybridTrainMaintenance(VehicleRegistrationMediator mediatorevent) {

        String catenaryMaintenanceKM = mediatorevent.catenaryMaintenanceKM;
        String pantographMaintenanceKM = mediatorevent.pantographMaintenanceKM;
        String circuitBreakersMaintenanceKM = mediatorevent.circuitBreakersMaintenanceKM;
        String catenaryNextMaintenanceDate = mediatorevent.catenaryNextMaintenanceDate;
        String pantographNextMaintenanceDate = mediatorevent.pantographNextMaintenanceDate;
        String circuitBreakersNextMaintenanceDate = mediatorevent.circuitBreakersNextMaintenanceDate;
        String catenaryLastMaintenanceDate = mediatorevent.catenaryLastMaintenanceDate;
        String pantographLastMaintenanceDate = mediatorevent.pantographLastMaintenanceDate;
        String circuitBreakersLastMaintenanceDate = mediatorevent.circuitBreakersLastMaintenanceDate;

        String nextServiceOverhaulDate = mediatorevent.nextServiceOverhaulDate;
        String lastServiceOverhaulDate = mediatorevent.lastServiceOverhaulDate;

        HybridTrainMaintenanceSchedule hybridTrainMaintenanceSchedule = new HybridTrainMaintenanceSchedule();

        hybridTrainMaintenanceSchedule.setCatenaryMaintenaceKM(catenaryMaintenanceKM);
        hybridTrainMaintenanceSchedule.setPantographMaintenanceKM(pantographMaintenanceKM);
        hybridTrainMaintenanceSchedule.setCircuitBreakersMaintenanceKM(circuitBreakersMaintenanceKM);
        hybridTrainMaintenanceSchedule.setCatenaryNextMaintenanceDate(catenaryNextMaintenanceDate);
        hybridTrainMaintenanceSchedule.setPantographNextMaintenanceDate(pantographNextMaintenanceDate);
        hybridTrainMaintenanceSchedule.setCircuitBreakerNextMaintenanceDate(circuitBreakersNextMaintenanceDate);
        hybridTrainMaintenanceSchedule.setNextServiceOverhaulDate(nextServiceOverhaulDate);

        return hybridTrainMaintenanceSchedule;
    }
}
