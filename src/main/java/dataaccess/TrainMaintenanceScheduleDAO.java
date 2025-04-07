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
 * Data Access Object for train maintenance schedules
 *
 * @author roland
 */
public class TrainMaintenanceScheduleDAO {

    /**
     * Create a new train maintenance schedule
     *
     * @param vehicleId The associated vehicle's ID
     * @param catenaryMaintenanceKm The maintenance kilometer for catenary
     * @param pantographMaintenanceKm The maintenance kilometer for pantograph
     * @param circuitBreakersMaintenanceKm The maintenance kilometer for circuit
     * breakers
     * @param catenaryNextMaintenanceDate The next maintenance date for catenary
     * @param catenaryLastMaintenanceDate The last maintenance date for catenary
     * @param pantographNextMaintenanceDate The next maintenance date for
     * pantograph
     * @param pantographLastMaintenanceDate The last maintenance date for
     * pantograph
     * @param circuitBreakersNextMaintenanceDate The next maintenance date for
     * circuit breakers
     * @param circuitBreakersLastMaintenanceDate The last maintenance date for
     * circuit breakers
     * @param nextServiceOverhaulDate The next service overhaul date
     * @param lastServiceOverhaulDate The last service overhaul date
     * @return The ID of the newly created schedule
     */
    public int createTrainMaintenanceSchedule(
            int vehicleId,
            int catenaryMaintenanceKm,
            int pantographMaintenanceKm,
            int circuitBreakersMaintenanceKm,
            LocalDate catenaryNextMaintenanceDate,
            LocalDate catenaryLastMaintenanceDate,
            LocalDate pantographNextMaintenanceDate,
            LocalDate pantographLastMaintenanceDate,
            LocalDate circuitBreakersNextMaintenanceDate,
            LocalDate circuitBreakersLastMaintenanceDate,
            LocalDate nextServiceOverhaulDate,
            LocalDate lastServiceOverhaulDate) {

        String sql = "INSERT INTO train_maintenance_schedules (vehicle_id, catenary_maintenance_km, "
                + "pantograph_maintenance_km, circuit_breakers_maintenance_km, "
                + "catenary_next_maintenance_date, catenary_last_maintenance_date, "
                + "pantograph_next_maintenance_date, pantograph_last_maintenance_date, "
                + "circuit_breakers_next_maintenance_date, circuit_breakers_last_maintenance_date, "
                + "next_service_overhaul_date, last_service_overhaul_date) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, vehicleId);
            stmt.setInt(2, catenaryMaintenanceKm);
            stmt.setInt(3, pantographMaintenanceKm);
            stmt.setInt(4, circuitBreakersMaintenanceKm);

            stmt.setDate(5, catenaryNextMaintenanceDate != null ? Date.valueOf(catenaryNextMaintenanceDate) : null);
            stmt.setDate(6, catenaryLastMaintenanceDate != null ? Date.valueOf(catenaryLastMaintenanceDate) : null);
            stmt.setDate(7, pantographNextMaintenanceDate != null ? Date.valueOf(pantographNextMaintenanceDate) : null);
            stmt.setDate(8, pantographLastMaintenanceDate != null ? Date.valueOf(pantographLastMaintenanceDate) : null);
            stmt.setDate(9, circuitBreakersNextMaintenanceDate != null ? Date.valueOf(circuitBreakersNextMaintenanceDate) : null);
            stmt.setDate(10, circuitBreakersLastMaintenanceDate != null ? Date.valueOf(circuitBreakersLastMaintenanceDate) : null);
            stmt.setDate(11, nextServiceOverhaulDate != null ? Date.valueOf(nextServiceOverhaulDate) : null);
            stmt.setDate(12, lastServiceOverhaulDate != null ? Date.valueOf(lastServiceOverhaulDate) : null);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating train maintenance schedule failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating train maintenance schedule failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Get a train maintenance schedule by vehicle ID
     *
     * @param vehicleId The vehicle ID
     * @return Object array containing the schedule details
     */
    public Object[] getTrainMaintenanceScheduleByVehicleId(int vehicleId) {
        String sql = "SELECT * FROM train_maintenance_schedules WHERE vehicle_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Object[] schedule = new Object[13];
                    schedule[0] = rs.getInt("schedule_id");
                    schedule[1] = rs.getInt("vehicle_id");
                    schedule[2] = rs.getInt("catenary_maintenance_km");
                    schedule[3] = rs.getInt("pantograph_maintenance_km");
                    schedule[4] = rs.getInt("circuit_breakers_maintenance_km");

                    // Convert SQL Date to LocalDate
                    schedule[5] = rs.getDate("catenary_next_maintenance_date") != null
                            ? rs.getDate("catenary_next_maintenance_date").toLocalDate() : null;
                    schedule[6] = rs.getDate("catenary_last_maintenance_date") != null
                            ? rs.getDate("catenary_last_maintenance_date").toLocalDate() : null;
                    schedule[7] = rs.getDate("pantograph_next_maintenance_date") != null
                            ? rs.getDate("pantograph_next_maintenance_date").toLocalDate() : null;
                    schedule[8] = rs.getDate("pantograph_last_maintenance_date") != null
                            ? rs.getDate("pantograph_last_maintenance_date").toLocalDate() : null;
                    schedule[9] = rs.getDate("circuit_breakers_next_maintenance_date") != null
                            ? rs.getDate("circuit_breakers_next_maintenance_date").toLocalDate() : null;
                    schedule[10] = rs.getDate("circuit_breakers_last_maintenance_date") != null
                            ? rs.getDate("circuit_breakers_last_maintenance_date").toLocalDate() : null;
                    schedule[11] = rs.getDate("next_service_overhaul_date") != null
                            ? rs.getDate("next_service_overhaul_date").toLocalDate() : null;
                    schedule[12] = rs.getDate("last_service_overhaul_date") != null
                            ? rs.getDate("last_service_overhaul_date").toLocalDate() : null;

                    return schedule;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Update a train maintenance schedule
     *
     * @param scheduleId The schedule ID
     * @param catenaryMaintenanceKm The maintenance kilometer for catenary
     * @param pantographMaintenanceKm The maintenance kilometer for pantograph
     * @param circuitBreakersMaintenanceKm The maintenance kilometer for circuit
     * breakers
     * @param catenaryNextMaintenanceDate The next maintenance date for catenary
     * @param catenaryLastMaintenanceDate The last maintenance date for catenary
     * @param pantographNextMaintenanceDate The next maintenance date for
     * pantograph
     * @param pantographLastMaintenanceDate The last maintenance date for
     * pantograph
     * @param circuitBreakersNextMaintenanceDate The next maintenance date for
     * circuit breakers
     * @param circuitBreakersLastMaintenanceDate The last maintenance date for
     * circuit breakers
     * @param nextServiceOverhaulDate The next service overhaul date
     * @param lastServiceOverhaulDate The last service overhaul date
     * @return true if successful, false otherwise
     */
    public boolean updateTrainMaintenanceSchedule(
            int scheduleId,
            int catenaryMaintenanceKm,
            int pantographMaintenanceKm,
            int circuitBreakersMaintenanceKm,
            LocalDate catenaryNextMaintenanceDate,
            LocalDate catenaryLastMaintenanceDate,
            LocalDate pantographNextMaintenanceDate,
            LocalDate pantographLastMaintenanceDate,
            LocalDate circuitBreakersNextMaintenanceDate,
            LocalDate circuitBreakersLastMaintenanceDate,
            LocalDate nextServiceOverhaulDate,
            LocalDate lastServiceOverhaulDate) {

        String sql = "UPDATE train_maintenance_schedules SET catenary_maintenance_km = ?, "
                + "pantograph_maintenance_km = ?, circuit_breakers_maintenance_km = ?, "
                + "catenary_next_maintenance_date = ?, catenary_last_maintenance_date = ?, "
                + "pantograph_next_maintenance_date = ?, pantograph_last_maintenance_date = ?, "
                + "circuit_breakers_next_maintenance_date = ?, circuit_breakers_last_maintenance_date = ?, "
                + "next_service_overhaul_date = ?, last_service_overhaul_date = ? "
                + "WHERE schedule_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, catenaryMaintenanceKm);
            stmt.setInt(2, pantographMaintenanceKm);
            stmt.setInt(3, circuitBreakersMaintenanceKm);

            stmt.setDate(4, catenaryNextMaintenanceDate != null ? Date.valueOf(catenaryNextMaintenanceDate) : null);
            stmt.setDate(5, catenaryLastMaintenanceDate != null ? Date.valueOf(catenaryLastMaintenanceDate) : null);
            stmt.setDate(6, pantographNextMaintenanceDate != null ? Date.valueOf(pantographNextMaintenanceDate) : null);
            stmt.setDate(7, pantographLastMaintenanceDate != null ? Date.valueOf(pantographLastMaintenanceDate) : null);
            stmt.setDate(8, circuitBreakersNextMaintenanceDate != null ? Date.valueOf(circuitBreakersNextMaintenanceDate) : null);
            stmt.setDate(9, circuitBreakersLastMaintenanceDate != null ? Date.valueOf(circuitBreakersLastMaintenanceDate) : null);
            stmt.setDate(10, nextServiceOverhaulDate != null ? Date.valueOf(nextServiceOverhaulDate) : null);
            stmt.setDate(11, lastServiceOverhaulDate != null ? Date.valueOf(lastServiceOverhaulDate) : null);

            stmt.setInt(12, scheduleId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Update train maintenance schedule by vehicle ID
     *
     * @param vehicleId The vehicle ID
     * @param catenaryMaintenanceKm The maintenance kilometer for catenary
     * @param pantographMaintenanceKm The maintenance kilometer for pantograph
     * @param circuitBreakersMaintenanceKm The maintenance kilometer for circuit
     * breakers
     * @param catenaryNextMaintenanceDate The next maintenance date for catenary
     * @param catenaryLastMaintenanceDate The last maintenance date for catenary
     * @param pantographNextMaintenanceDate The next maintenance date for
     * pantograph
     * @param pantographLastMaintenanceDate The last maintenance date for
     * pantograph
     * @param circuitBreakersNextMaintenanceDate The next maintenance date for
     * circuit breakers
     * @param circuitBreakersLastMaintenanceDate The last maintenance date for
     * circuit breakers
     * @param nextServiceOverhaulDate The next service overhaul date
     * @param lastServiceOverhaulDate The last service overhaul date
     * @return true if successful, false otherwise
     */
    public boolean updateTrainMaintenanceScheduleByVehicleId(
            int vehicleId,
            int catenaryMaintenanceKm,
            int pantographMaintenanceKm,
            int circuitBreakersMaintenanceKm,
            LocalDate catenaryNextMaintenanceDate,
            LocalDate catenaryLastMaintenanceDate,
            LocalDate pantographNextMaintenanceDate,
            LocalDate pantographLastMaintenanceDate,
            LocalDate circuitBreakersNextMaintenanceDate,
            LocalDate circuitBreakersLastMaintenanceDate,
            LocalDate nextServiceOverhaulDate,
            LocalDate lastServiceOverhaulDate) {

        String sql = "UPDATE train_maintenance_schedules SET catenary_maintenance_km = ?, "
                + "pantograph_maintenance_km = ?, circuit_breakers_maintenance_km = ?, "
                + "catenary_next_maintenance_date = ?, catenary_last_maintenance_date = ?, "
                + "pantograph_next_maintenance_date = ?, pantograph_last_maintenance_date = ?, "
                + "circuit_breakers_next_maintenance_date = ?, circuit_breakers_last_maintenance_date = ?, "
                + "next_service_overhaul_date = ?, last_service_overhaul_date = ? "
                + "WHERE vehicle_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, catenaryMaintenanceKm);
            stmt.setInt(2, pantographMaintenanceKm);
            stmt.setInt(3, circuitBreakersMaintenanceKm);

            stmt.setDate(4, catenaryNextMaintenanceDate != null ? Date.valueOf(catenaryNextMaintenanceDate) : null);
            stmt.setDate(5, catenaryLastMaintenanceDate != null ? Date.valueOf(catenaryLastMaintenanceDate) : null);
            stmt.setDate(6, pantographNextMaintenanceDate != null ? Date.valueOf(pantographNextMaintenanceDate) : null);
            stmt.setDate(7, pantographLastMaintenanceDate != null ? Date.valueOf(pantographLastMaintenanceDate) : null);
            stmt.setDate(8, circuitBreakersNextMaintenanceDate != null ? Date.valueOf(circuitBreakersNextMaintenanceDate) : null);
            stmt.setDate(9, circuitBreakersLastMaintenanceDate != null ? Date.valueOf(circuitBreakersLastMaintenanceDate) : null);
            stmt.setDate(10, nextServiceOverhaulDate != null ? Date.valueOf(nextServiceOverhaulDate) : null);
            stmt.setDate(11, lastServiceOverhaulDate != null ? Date.valueOf(lastServiceOverhaulDate) : null);

            stmt.setInt(12, vehicleId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete a train maintenance schedule
     *
     * @param scheduleId The schedule ID
     * @return true if successful, false otherwise
     */
    public boolean deleteTrainMaintenanceSchedule(int scheduleId) {
        String sql = "DELETE FROM train_maintenance_schedules WHERE schedule_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, scheduleId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete a train maintenance schedule by vehicle ID
     *
     * @param vehicleId The vehicle ID
     * @return true if successful, false otherwise
     */
    public boolean deleteTrainMaintenanceScheduleByVehicleId(int vehicleId) {
        String sql = "DELETE FROM train_maintenance_schedules WHERE vehicle_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
