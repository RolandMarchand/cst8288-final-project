package com.business.vehicle.makevehicle;

import com.business.contract.controller.VehicleRegistrationMediator;
import com.business.contract.vehicle.vehicleparts.BusPartsContract;

/**
 *
 * @author D. Santos
 */
public class DieselMaintenanceBuilder extends DieselBusMaintenanceSchedule {

    VehicleRegistrationMediator mediatorEvent;

    public DieselMaintenanceBuilder(VehicleRegistrationMediator mediatorevent) {
    }
 
    public DieselBusMaintenanceSchedule buildDieselMaintenance(VehicleRegistrationMediator mediatorevent) {

        String brakesMaintenanceKM = mediatorevent.brakesMaintenanceKM;
        String tiresMaintenanceKM = mediatorevent.tiresMaintenanceKM;
        String busAxleBearingAMaintenanceKM = mediatorevent.busAxleBearingAMaintenanceKM;
        String busAxleBearingBMaintenanceKM = mediatorevent.busAxleBearingBMaintenanceKM;
        String brakesNextMaintenanceDate = mediatorevent.brakesNextMaintenanceDate;
        String brakesLastMaintenanceDate = mediatorevent.brakesLastMaintenanceDate;
        String tiresNextMaintenanceDate = mediatorevent.tiresNextMaintenanceDate;
        String tiresLastMaintenanceDate = mediatorevent.tiresLastMaintenanceDate;
        String busAxleBearingANextMaintenanceDate = mediatorevent.busAxleBearingANextMaintenanceDate;
        String busAxleBearingALastMaintenanceDate = mediatorevent.busAxleBearingALastMaintenanceDate;
        String busAxleBearingBNextMaintenanceDate = mediatorevent.busAxleBearingBNextMaintenanceDate;
        String busAxleBearingBLastMaintenanceDate = mediatorevent.busAxleBearingALastMaintenanceDate;
        String nextServiceOverhaulDate = mediatorevent.nextServiceOverhaulDate;
        String lastServiceOverhaulDate = mediatorevent.lastServiceOverhaulDate;

        DieselBusMaintenanceSchedule dieselMaintenanceSchedule = new DieselBusMaintenanceSchedule();
        dieselMaintenanceSchedule.setBrakeMaintenanceKM(brakesMaintenanceKM);
        dieselMaintenanceSchedule.setTiresMaintenanceKM(tiresMaintenanceKM);
        dieselMaintenanceSchedule.setAxleBearingAMaintenanceKM(busAxleBearingAMaintenanceKM);
        dieselMaintenanceSchedule.setAxleBearingBMaintenanceKM(busAxleBearingBMaintenanceKM);
        dieselMaintenanceSchedule.setBrakesNextMaintenanceDate(brakesNextMaintenanceDate);
        dieselMaintenanceSchedule.setTiresNextMaintenanceDate(tiresNextMaintenanceDate);
        dieselMaintenanceSchedule.setAxleBearingANextMaintenanceDate(busAxleBearingANextMaintenanceDate);
        dieselMaintenanceSchedule.setAxleBearingBNextMaintenanceDate(busAxleBearingBNextMaintenanceDate);
        dieselMaintenanceSchedule.setNextServiceOverhaulDate(nextServiceOverhaulDate);

        return dieselMaintenanceSchedule;
    }
}
