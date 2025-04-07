/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for BusMaintenanceScheduleDAO Note: This test class assumes access
 * to a test database
 */
class BusMaintenanceScheduleDAOTest {

    private BusMaintenanceScheduleDAO dao;
    private int vehicleId;

    @BeforeEach
    void setup() {
        dao = new BusMaintenanceScheduleDAO();
        vehicleId = createDummyVehicle();
    }
    
    @AfterEach
    void cleanup() {
        deleteDummyVehicle(vehicleId);
    }

    @Test
    void testCreateBusMaintenanceSchedule() {
        int brakesMaintenanceKm = 10000;
        int tiresMaintenanceKm = 15000;
        int axleBearingAMaintenanceKm = 20000;
        int axleBearingBMaintenanceKm = 25000;
        LocalDate now = LocalDate.now();
        LocalDate nextMonth = now.plusMonths(1);
        LocalDate lastMonth = now.minusMonths(1);

        // Execute the method
        int scheduleId = dao.createSchedule(
                vehicleId,
                brakesMaintenanceKm,
                tiresMaintenanceKm,
                axleBearingAMaintenanceKm,
                axleBearingBMaintenanceKm,
                nextMonth, // brakes next
                lastMonth, // brakes last
                nextMonth, // tires next
                lastMonth, // tires last
                nextMonth, // axleA next
                lastMonth, // axleA last
                nextMonth, // axleB next
                lastMonth, // axleB last
                nextMonth, // service next
                lastMonth // service last
        );
        
        dao.deleteSchedule(scheduleId);

        // Assert result - In real test we would validate the inserted record
        // For now, just check that we got a valid ID (greater than 0)
        assertTrue(scheduleId > 0, "Should return valid schedule ID");
    }

    /**
     * Testing with invalid data - expecting SQL exception to be caught and
     * method to return -1
     */
    @Test
    void testCreateBusMaintenanceScheduleWithInvalidData() {
        // Use an invalid vehicle ID (assuming -999 doesn't exist)
        int invalidVehicleId = -999;

        int result = dao.createSchedule(
                invalidVehicleId,
                10000,
                15000,
                20000,
                25000,
                LocalDate.now(),
                LocalDate.now(),
                LocalDate.now(),
                LocalDate.now(),
                LocalDate.now(),
                LocalDate.now(),
                LocalDate.now(),
                LocalDate.now(),
                LocalDate.now(),
                LocalDate.now()
        );

        // The method should catch SQL exceptions and return -1
        assertEquals(-1, result, "Should return -1 for invalid data");
    }

    /**
     * Test with null date values - the method should handle this
     */
    @Test
    void testCreateBusMaintenanceScheduleWithNullDates() {

        // Execute the method with null dates
        int scheduleId = dao.createSchedule(
                vehicleId,
                10000,
                15000,
                20000,
                25000,
                null, // brakes next
                null, // brakes last
                null, // tires next
                null, // tires last
                null, // axleA next
                null, // axleA last
                null, // axleB next
                null, // axleB last
                null, // service next
                null // service last
        );
        
        dao.deleteSchedule(scheduleId);

        // Should still create a record with null dates
        assertTrue(scheduleId > 0, "Should return valid schedule ID even with null dates");
    }

    private int createDummyVehicle() { 
        VehicleDAO vehicleDAO = new VehicleDAO();

        // Define test vehicle data
        String registrationNumber = "ABC123";
        String vehicleTypeId = "BUS_MINIBUS";
        String fuelEnergyTypeId = "DIESEL";
        double consumptionRate = 12.5;
        int maxPassengers = 45;
        Integer currentRouteId = null;

        // Call the createVehicle method
        int vehicleId = vehicleDAO.createVehicle(
                registrationNumber,
                vehicleTypeId,
                fuelEnergyTypeId,
                consumptionRate,
                maxPassengers,
                currentRouteId
        );

        // Check the result
        if (vehicleId <= 0) {
            throw new AssertionError("Failed to create a test vehicle.");
        }
        
        return vehicleId;
    }
    
    private void deleteDummyVehicle(int id) {
        VehicleDAO vehicleDAO = new VehicleDAO();
        vehicleDAO.deleteVehicle(id);
    }
}
