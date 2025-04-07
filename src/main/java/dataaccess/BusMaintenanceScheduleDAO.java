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
     * Create a new bus maintenance schedule
     *
     * @param vehicleId The associated vehicle's ID
     * @param brakesMaintenanceKm The maintenance kilometer for brakes
     * @param tiresMaintenanceKm The maintenance kilometer for tires
     * @param axleBearingAMaintenanceKm The maintenance kilometer for axle
     * bearing A
     * @param axleBearingBMaintenanceKm The maintenance kilometer for axle
     * bearing B
     * @param brakesNextMaintenanceDate The next maintenance date for brakes
     * @param brakesLastMaintenanceDate The last maintenance date for brakes
     * @param tiresNextMaintenanceDate The next maintenance date for tires
     * @param tiresLastMaintenanceDate The last maintenance date for tires
     * @param axleBearingANextMaintenanceDate The next maintenance date for axle
     * bearing A
     * @param axleBearingALastMaintenanceDate The last maintenance date for axle
     * bearing A
     * @param axleBearingBNextMaintenanceDate The next maintenance date for axle
     * bearing B
     * @param axleBearingBLastMaintenanceDate The last maintenance date for axle
     * bearing B
     * @param nextServiceOverhaulDate The next service overhaul date
     * @param lastServiceOverhaulDate The last service overhaul date
     * @return The ID of the newly created schedule, or -1 if an error occurred
     */
    public int createSchedule(
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

    /**
     * Get a bus maintenance schedule by schedule ID
     *
     * @param scheduleId The schedule ID
     * @return Object array containing the schedule details or null if not found
     */
    public Object[] getScheduleById(int scheduleId) {
        String sql = "SELECT * FROM bus_maintenance_schedules WHERE schedule_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, scheduleId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractScheduleFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get a bus maintenance schedule by vehicle ID
     *
     * @param vehicleId The vehicle ID
     * @return Object array containing the schedule details or null if not found
     */
    public Object[] getScheduleByVehicleId(int vehicleId) {
        String sql = "SELECT * FROM bus_maintenance_schedules WHERE vehicle_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractScheduleFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Helper method to extract schedule data from a ResultSet
     *
     * @param rs The ResultSet containing the schedule data
     * @return Object array containing the schedule details
     * @throws SQLException If an error occurs while reading from the ResultSet
     */
    private Object[] extractScheduleFromResultSet(ResultSet rs) throws SQLException {
        Object[] schedule = new Object[16];
        schedule[0] = rs.getInt("schedule_id");
        schedule[1] = rs.getInt("vehicle_id");
        schedule[2] = rs.getInt("brakes_maintenance_km");
        schedule[3] = rs.getInt("tires_maintenance_km");
        schedule[4] = rs.getInt("axle_bearing_a_maintenance_km");
        schedule[5] = rs.getInt("axle_bearing_b_maintenance_km");

        // Convert SQL Date to LocalDate
        schedule[6] = rs.getDate("brakes_next_maintenance_date") != null
                ? rs.getDate("brakes_next_maintenance_date").toLocalDate() : null;
        schedule[7] = rs.getDate("brakes_last_maintenance_date") != null
                ? rs.getDate("brakes_last_maintenance_date").toLocalDate() : null;
        schedule[8] = rs.getDate("tires_next_maintenance_date") != null
                ? rs.getDate("tires_next_maintenance_date").toLocalDate() : null;
        schedule[9] = rs.getDate("tires_last_maintenance_date") != null
                ? rs.getDate("tires_last_maintenance_date").toLocalDate() : null;
        schedule[10] = rs.getDate("axle_bearing_a_next_maintenance_date") != null
                ? rs.getDate("axle_bearing_a_next_maintenance_date").toLocalDate() : null;
        schedule[11] = rs.getDate("axle_bearing_a_last_maintenance_date") != null
                ? rs.getDate("axle_bearing_a_last_maintenance_date").toLocalDate() : null;
        schedule[12] = rs.getDate("axle_bearing_b_next_maintenance_date") != null
                ? rs.getDate("axle_bearing_b_next_maintenance_date").toLocalDate() : null;
        schedule[13] = rs.getDate("axle_bearing_b_last_maintenance_date") != null
                ? rs.getDate("axle_bearing_b_last_maintenance_date").toLocalDate() : null;
        schedule[14] = rs.getDate("next_service_overhaul_date") != null
                ? rs.getDate("next_service_overhaul_date").toLocalDate() : null;
        schedule[15] = rs.getDate("last_service_overhaul_date") != null
                ? rs.getDate("last_service_overhaul_date").toLocalDate() : null;

        return schedule;
    }

    /**
     * Update a bus maintenance schedule by schedule ID
     *
     * @param scheduleId The schedule ID
     * @param brakesMaintenanceKm The maintenance kilometer for brakes
     * @param tiresMaintenanceKm The maintenance kilometer for tires
     * @param axleBearingAMaintenanceKm The maintenance kilometer for axle
     * bearing A
     * @param axleBearingBMaintenanceKm The maintenance kilometer for axle
     * bearing B
     * @param brakesNextMaintenanceDate The next maintenance date for brakes
     * @param brakesLastMaintenanceDate The last maintenance date for brakes
     * @param tiresNextMaintenanceDate The next maintenance date for tires
     * @param tiresLastMaintenanceDate The last maintenance date for tires
     * @param axleBearingANextMaintenanceDate The next maintenance date for axle
     * bearing A
     * @param axleBearingALastMaintenanceDate The last maintenance date for axle
     * bearing A
     * @param axleBearingBNextMaintenanceDate The next maintenance date for axle
     * bearing B
     * @param axleBearingBLastMaintenanceDate The last maintenance date for axle
     * bearing B
     * @param nextServiceOverhaulDate The next service overhaul date
     * @param lastServiceOverhaulDate The last service overhaul date
     * @return true if successful, false otherwise
     */
    public boolean updateSchedule(
            int scheduleId,
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

        String sql = "UPDATE bus_maintenance_schedules SET brakes_maintenance_km = ?, "
                + "tires_maintenance_km = ?, axle_bearing_a_maintenance_km = ?, axle_bearing_b_maintenance_km = ?, "
                + "brakes_next_maintenance_date = ?, brakes_last_maintenance_date = ?, "
                + "tires_next_maintenance_date = ?, tires_last_maintenance_date = ?, "
                + "axle_bearing_a_next_maintenance_date = ?, axle_bearing_a_last_maintenance_date = ?, "
                + "axle_bearing_b_next_maintenance_date = ?, axle_bearing_b_last_maintenance_date = ?, "
                + "next_service_overhaul_date = ?, last_service_overhaul_date = ? "
                + "WHERE schedule_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, brakesMaintenanceKm);
            stmt.setInt(2, tiresMaintenanceKm);
            stmt.setInt(3, axleBearingAMaintenanceKm);
            stmt.setInt(4, axleBearingBMaintenanceKm);

            stmt.setDate(5, brakesNextMaintenanceDate != null ? Date.valueOf(brakesNextMaintenanceDate) : null);
            stmt.setDate(6, brakesLastMaintenanceDate != null ? Date.valueOf(brakesLastMaintenanceDate) : null);
            stmt.setDate(7, tiresNextMaintenanceDate != null ? Date.valueOf(tiresNextMaintenanceDate) : null);
            stmt.setDate(8, tiresLastMaintenanceDate != null ? Date.valueOf(tiresLastMaintenanceDate) : null);
            stmt.setDate(9, axleBearingANextMaintenanceDate != null ? Date.valueOf(axleBearingANextMaintenanceDate) : null);
            stmt.setDate(10, axleBearingALastMaintenanceDate != null ? Date.valueOf(axleBearingALastMaintenanceDate) : null);
            stmt.setDate(11, axleBearingBNextMaintenanceDate != null ? Date.valueOf(axleBearingBNextMaintenanceDate) : null);
            stmt.setDate(12, axleBearingBLastMaintenanceDate != null ? Date.valueOf(axleBearingBLastMaintenanceDate) : null);
            stmt.setDate(13, nextServiceOverhaulDate != null ? Date.valueOf(nextServiceOverhaulDate) : null);
            stmt.setDate(14, lastServiceOverhaulDate != null ? Date.valueOf(lastServiceOverhaulDate) : null);

            stmt.setInt(15, scheduleId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete a bus maintenance schedule by schedule ID
     *
     * @param scheduleId The schedule ID
     * @return true if successful, false otherwise
     */
    public boolean deleteSchedule(int scheduleId) {
        String sql = "DELETE FROM bus_maintenance_schedules WHERE schedule_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, scheduleId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
