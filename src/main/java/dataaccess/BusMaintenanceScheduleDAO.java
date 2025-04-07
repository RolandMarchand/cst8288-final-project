/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Handles all database operations related to 
 * bus maintenance schedules.
 * 
 * This class creates new maintenance records 
 * for buses and stores them in the database.
 * 
 * It connects to the database using the DataSource class.
 * 
 * Author: roland
 */
public class BusMaintenanceScheduleDAO {

    /**
     * Saves a new bus maintenance schedule in the database.
     * 
     * @param vehicleId ID of the bus
     * @param brakesMaintenanceKm KM value when brakes need maintenance
     * @param tiresMaintenanceKm KM value when tires need maintenance
     * @param axleBearingAMaintenanceKm KM value when axle bearing A needs maintenance
     * @param axleBearingBMaintenanceKm KM value when axle bearing B needs maintenance
     * @param brakesNextMaintenanceDate Next scheduled date for brake maintenance
     * @param brakesLastMaintenanceDate Last completed brake maintenance date
     * @param tiresNextMaintenanceDate Next scheduled date for tire maintenance
     * @param tiresLastMaintenanceDate Last completed tire maintenance date
     * @param axleBearingANextMaintenanceDate Next date for axle bearing A maintenance
     * @param axleBearingALastMaintenanceDate Last date axle bearing A was maintained
     * @param axleBearingBNextMaintenanceDate Next date for axle bearing B maintenance
     * @param axleBearingBLastMaintenanceDate Last date axle bearing B was maintained
     * @param nextServiceOverhaulDate Next full service overhaul date
     * @param lastServiceOverhaulDate Last full service overhaul date
     * @return The new maintenance schedule ID, or -1 if failed
     */
    public int createBusMaintenanceSchedule(
            int vehicleId,
            int brakesMaintenanceKm,
            int tiresMaintenanceKm,
            int axleBearingAMaintenanceKm,
            int axleBearingBMaintenanceKm,
            LocalDate brakesNextMaintenanceDate,
            LocalDate brakesLastMaintenanceDate,
            LocalDate tiresNextMaintenanceDate,
            LocalDate tiresLastMaintenanceDate,
            LocalDate axleBearingANextMaintenanceDate,
            LocalDate axleBearingALastMaintenanceDate,
            LocalDate axleBearingBNextMaintenanceDate,
            LocalDate axleBearingBLastMaintenanceDate,
            LocalDate nextServiceOverhaulDate,
            LocalDate lastServiceOverhaulDate) {

        String sql = "INSERT INTO bus_maintenance_schedules (vehicle_id, brakes_maintenance_km, "
                + "tires_maintenance_km, axle_bearing_a_maintenance_km, axle_bearing_b_maintenance_km, "
                + "brakes_next_maintenance_date, brakes_last_maintenance_date, "
                + "tires_next_maintenance_date, tires_last_maintenance_date, "
                + "axle_bearing_a_next_maintenance_date, axle_bearing_a_last_maintenance_date, "
                + "axle_bearing_b_next_maintenance_date, axle_bearing_b_last_maintenance_date, "
                + "next_service_overhaul_date, last_service_overhaul_date) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataSource.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, vehicleId);
            stmt.setInt(2, brakesMaintenanceKm);
            stmt.setInt(3, tiresMaintenanceKm);
            stmt.setInt(4, axleBearingAMaintenanceKm);
            stmt.setInt(5, axleBearingBMaintenanceKm);

            stmt.setDate(6, brakesNextMaintenanceDate != null ? Date.valueOf(brakesNextMaintenanceDate) : null);
            stmt.setDate(7, brakesLastMaintenanceDate != null ? Date.valueOf(brakesLastMaintenanceDate) : null);
            stmt.setDate(8, tiresNextMaintenanceDate != null ? Date.valueOf(tiresNextMaintenanceDate) : null);
            stmt.setDate(9, tiresLastMaintenanceDate != null ? Date.valueOf(tiresLastMaintenanceDate) : null);
            stmt.setDate(10, axleBearingANextMaintenanceDate != null ? Date.valueOf(axleBearingANextMaintenanceDate) : null);
            stmt.setDate(11, axleBearingALastMaintenanceDate != null ? Date.valueOf(axleBearingALastMaintenanceDate) : null);
            stmt.setDate(12, axleBearingBNextMaintenanceDate != null ? Date.valueOf(axleBearingBNextMaintenanceDate) : null);
            stmt.setDate(13, axleBearingBLastMaintenanceDate != null ? Date.valueOf(axleBearingBLastMaintenanceDate) : null);
            stmt.setDate(14, nextServiceOverhaulDate != null ? Date.valueOf(nextServiceOverhaulDate) : null);
            stmt.setDate(15, lastServiceOverhaulDate != null ? Date.valueOf(lastServiceOverhaulDate) : null);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating bus maintenance schedule failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating bus maintenance schedule failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
