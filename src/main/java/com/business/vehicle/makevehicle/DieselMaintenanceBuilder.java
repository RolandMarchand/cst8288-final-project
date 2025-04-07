package com.business.vehicle.makevehicle;

import com.business.contract.controller.VehicleRegistrationMediator;
import com.business.contract.vehicle.vehicleparts.BusPartsContract;

/**
 * This class helps build a DieselBusMaintenanceSchedule using data 
 * from a VehicleRegistrationMediator.
 *
 * It sets maintenance kilometers, dates, and service schedules for diesel buses.
 *
 * @author: D. Santos
 */
public class DieselMaintenanceBuilder extends DieselBusMaintenanceSchedule {

    VehicleRegistrationMediator mediatorEvent;

    /**
     * Creates a DieselMaintenanceBuilder using the given mediator.
     *
     * @param mediatorevent the object that holds vehicle maintenance values
     */
    public DieselMaintenanceBuilder(VehicleRegistrationMediator mediatorevent) {
    }

    /**
     * Builds and returns a DieselBusMaintenanceSchedule with values
     * provided by the mediator.
     *
     * @param mediatorevent the object that holds vehicle maintenance values
     * @return a DieselBusMaintenanceSchedule filled with the mediator's data
     */
    public DieselBusMaintenanceSchedule buildDieselMaintenance(VehicleRegistrationMediator mediatorevent) {

        // Get maintenance KM values
        String brakesMaintenanceKM = mediatorevent.brakesMaintenanceKM;
        String tiresMaintenanceKM = mediatorevent.tiresMaintenanceKM;
        String busAxleBearingAMaintenanceKM = mediatorevent.busAxleBearingAMaintenanceKM;
        String busAxleBearingBMaintenanceKM = mediatorevent.busAxleBearingBMaintenanceKM;

        // Get next and last maintenance dates
        String brakesNextMaintenanceDate = mediatorevent.brakesNextMaintenanceDate;
        String brakesLastMaintenanceDate = mediatorevent.brakesLastMaintenanceDate;
        String tiresNextMaintenanceDate = mediatorevent.tiresNextMaintenanceDate;
        String tiresLastMaintenanceDate = mediatorevent.tiresLastMaintenanceDate;
        String busAxleBearingANextMaintenanceDate = mediatorevent.busAxleBearingANextMaintenanceDate;
        String busAxleBearingALastMaintenanceDate = mediatorevent.busAxleBearingALastMaintenanceDate;
        String busAxleBearingBNextMaintenanceDate = mediatorevent.busAxleBearingBNextMaintenanceDate;
        String busAxleBearingBLastMaintenanceDate = mediatorevent.busAxleBearingBLastMaintenanceDate;

        // Get overhaul dates
        String nextServiceOverhaulDate = mediatorevent.nextServiceOverhaulDate;
        String lastServiceOverhaulDate = mediatorevent.lastServiceOverhaulDate;

        // Create and populate the schedule
        DieselBusMaintenanceSchedule dieselMaintenanceSchedule = new DieselBusMaintenanceSchedule();
        dieselMaintenanceSchedule.setBrakeMaintenanceKM(brakesMaintenanceKM);
        dieselMaintenanceSchedule.setTiresMaintenanceKM(tiresMaintenanceKM);
        dieselMaintenanceSchedule.setAxleBearingAMaintenanceKM(busAxleBearingAMaintenanceKM);
        dieselMaintenanceSchedule.setAxleBearingBMaintenanceKM(busAxleBearingBMaintenanceKM);
        dieselMaintenanceSchedule.setBrakesNextMaintenanceDate(brakesNextMaintenanceDate);
        dieselMaintenanceSchedule.setTiresNextMaintenanceDate(tiresNextMaintenanceDate);
        dieselMaintenanceSchedule.setAxleBearingANextMaintenanceDate(busAxleBearingANextMaintenanceDate);
        dieselMaintenanceSchedule.setAxleBearingBNextMaintenanceDate(busAxleBearingBNextMaintenanceDate);
        dieselMaintenanceSchedule.setBrakesLastMaintenanceDate(brakesLastMaintenanceDate);
        dieselMaintenanceSchedule.setTiresLastMaintenanceDate(tiresLastMaintenanceDate);
        dieselMaintenanceSchedule.setAxleBearingALastMaintenanceDate(busAxleBearingALastMaintenanceDate);
        dieselMaintenanceSchedule.setAxleBearingBLastMaintenanceDate(busAxleBearingBLastMaintenanceDate);
        dieselMaintenanceSchedule.setNextServiceOverhaulDate(nextServiceOverhaulDate);
        dieselMaintenanceSchedule.setLastServiceOverhaulDate(lastServiceOverhaulDate);

        return dieselMaintenanceSchedule;
    }
}
