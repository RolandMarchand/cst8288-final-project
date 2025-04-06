package com.business.vehicle.makevehicle;

import com.business.contract.controller.VehicleRegistrationMediator;

/**
 *
 * @author D. Santos
 */
public class ElectricTrainMaintenanceBuilder extends ElectricTrainMaintenanceSchedule {

    VehicleRegistrationMediator mediatorEvent;

    public ElectricTrainMaintenanceBuilder(VehicleRegistrationMediator mediatorevent) {
    }

    public ElectricTrainMaintenanceSchedule buildElectricTrainMaintenance(VehicleRegistrationMediator mediatorevent) {

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
