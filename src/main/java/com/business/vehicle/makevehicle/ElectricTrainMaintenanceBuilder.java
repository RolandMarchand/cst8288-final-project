package com.business.vehicle.makevehicle;

import com.business.contract.controller.VehicleRegistrationMediator;

/**
 * Builder class for creating and filling an ElectricTrainMaintenanceSchedule
 * using values from VehicleRegistrationMediator.
 *
 * It sets details like kilometers for wear and tear, maintenance dates,
 * and service schedules.
 * 
 * @author D. Santos
 */
public class ElectricTrainMaintenanceBuilder extends ElectricTrainMaintenanceSchedule {

    VehicleRegistrationMediator mediatorEvent;

    /**
     * Creates an ElectricTrainMaintenanceBuilder with the given mediator.
     *
     * @param mediatorevent the mediator providing maintenance data
     */
    public ElectricTrainMaintenanceBuilder(VehicleRegistrationMediator mediatorevent) {
    }

    /**
     * Builds and returns an ElectricTrainMaintenanceSchedule using values
     * provided by the mediator.
     *
     * @param mediatorevent the mediator with electric train maintenance values
     * @return a fully set up ElectricTrainMaintenanceSchedule
     */
    public ElectricTrainMaintenanceSchedule buildElectricTrainMaintenance(VehicleRegistrationMediator mediatorevent) {

        // get kilometre wear and tear per part
        String catenaryMaintenanceKM = mediatorevent.catenaryMaintenanceKM;
        String pantographMaintenanceKM = mediatorevent.pantographMaintenanceKM;
        String circuitBreakersMaintenanceKM = mediatorevent.circuitBreakersMaintenanceKM;

        // get next scheduled maintenance date per part
        String catenaryNextMaintenanceDate = mediatorevent.catenaryNextMaintenanceDate;
        String pantographNextMaintenanceDate = mediatorevent.pantographNextMaintenanceDate;
        String circuitBreakersNextMaintenanceDate = mediatorevent.circuitBreakersNextMaintenanceDate;

        // get last completed maintenance date per part
        String catenaryLastMaintenanceDate = mediatorevent.catenaryLastMaintenanceDate;
        String pantographLastMaintenanceDate = mediatorevent.pantographLastMaintenanceDate;
        String circuitBreakersLastMaintenanceDate = mediatorevent.circuitBreakersLastMaintenanceDate;

        // get general service overhaul dates
        String nextServiceOverhaulDate = mediatorevent.nextServiceOverhaulDate;
        String lastServiceOverhaulDate = mediatorevent.lastServiceOverhaulDate;

        // create and fill maintenance schedule
        ElectricTrainMaintenanceSchedule electricTrainMaintenanceSchedule = new ElectricTrainMaintenanceSchedule();
        electricTrainMaintenanceSchedule.setCatenaryMaintenaceKM(catenaryMaintenanceKM);
        electricTrainMaintenanceSchedule.setPantographMaintenanceKM(pantographMaintenanceKM);
        electricTrainMaintenanceSchedule.setCircuitBreakersMaintenanceKM(circuitBreakersMaintenanceKM);
        electricTrainMaintenanceSchedule.setCatenaryNextMaintenanceDate(catenaryNextMaintenanceDate);
        electricTrainMaintenanceSchedule.setPantographNextMaintenanceDate(pantographNextMaintenanceDate);
        electricTrainMaintenanceSchedule.setCircuitBreakerNextMaintenanceDate(circuitBreakersNextMaintenanceDate);
        electricTrainMaintenanceSchedule.setNextServiceOverhaulDate(nextServiceOverhaulDate);

        return electricTrainMaintenanceSchedule;
    }
}
