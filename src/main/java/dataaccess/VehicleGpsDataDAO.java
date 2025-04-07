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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for vehicle GPS data
 *
 * @author roland
 */
public class VehicleGpsDataDAO {

    /**
     * Record a new GPS data point for a vehicle
     *
     * @param vehicleId The vehicle ID
     * @param timestamp The timestamp of the data point
     * @param latitude The vehicle's latitude
     * @param longitude The vehicle's longitude
     * @param fuelLevel The vehicle's fuel level (can be null)
     * @param vehicleRunning Whether the vehicle is running
     * @return The ID of the newly created GPS data point
     */
    public int recordGpsData(int vehicleId, LocalDateTime timestamp, double latitude,
            double longitude, Double fuelLevel, boolean vehicleRunning) {

        String sql = "INSERT INTO vehicle_gps_data (vehicle_id, timestamp, latitude, longitude, "
                + "fuel_level, vehicle_running) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, vehicleId);
            stmt.setTimestamp(2, Timestamp.valueOf(timestamp));
            stmt.setDouble(3, latitude);
            stmt.setDouble(4, longitude);

            if (fuelLevel != null) {
                stmt.setDouble(5, fuelLevel);
            } else {
                stmt.setNull(5, java.sql.Types.DECIMAL);
            }

            stmt.setBoolean(6, vehicleRunning);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Recording GPS data failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Recording GPS data failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Get the latest GPS data point for a vehicle
     *
     * @param vehicleId The vehicle ID
     * @return An object array containing the GPS data details
     */
    public Object[] getLatestGpsData(int vehicleId) {
        String sql = "SELECT * FROM vehicle_gps_data WHERE vehicle_id = ? "
                + "ORDER BY timestamp DESC LIMIT 1";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Object[] gpsData = new Object[7];
                    gpsData[0] = rs.getInt("gps_data_id");
                    gpsData[1] = rs.getInt("vehicle_id");
                    gpsData[2] = rs.getTimestamp("timestamp").toLocalDateTime();
                    gpsData[3] = rs.getDouble("latitude");
                    gpsData[4] = rs.getDouble("longitude");
                    gpsData[5] = rs.getObject("fuel_level") != null ? rs.getDouble("fuel_level") : null;
                    gpsData[6] = rs.getBoolean("vehicle_running");
                    return gpsData;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get GPS data points for a vehicle within a time range
     *
     * @param vehicleId The vehicle ID
     * @param startTime The start time of the range
     * @param endTime The end time of the range
     * @return A list of object arrays, each containing a GPS data point's
     * details
     */
    public List<Object[]> getGpsDataInTimeRange(int vehicleId, LocalDateTime startTime, LocalDateTime endTime) {
        List<Object[]> gpsDataPoints = new ArrayList<>();
        String sql = "SELECT * FROM vehicle_gps_data WHERE vehicle_id = ? "
                + "AND timestamp BETWEEN ? AND ? ORDER BY timestamp";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleId);
            stmt.setTimestamp(2, Timestamp.valueOf(startTime));
            stmt.setTimestamp(3, Timestamp.valueOf(endTime));

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Object[] gpsData = new Object[7];
                    gpsData[0] = rs.getInt("gps_data_id");
                    gpsData[1] = rs.getInt("vehicle_id");
                    gpsData[2] = rs.getTimestamp("timestamp").toLocalDateTime();
                    gpsData[3] = rs.getDouble("latitude");
                    gpsData[4] = rs.getDouble("longitude");
                    gpsData[5] = rs.getObject("fuel_level") != null ? rs.getDouble("fuel_level") : null;
                    gpsData[6] = rs.getBoolean("vehicle_running");
                    gpsDataPoints.add(gpsData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gpsDataPoints;
    }

    /**
     * Delete GPS data older than a specified date
     *
     * @param cutoffDate Data points older than this date will be deleted
     * @return The number of deleted data points
     */
    public int deleteOldGpsData(LocalDateTime cutoffDate) {
        String sql = "DELETE FROM vehicle_gps_data WHERE timestamp < ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, Timestamp.valueOf(cutoffDate));

            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
