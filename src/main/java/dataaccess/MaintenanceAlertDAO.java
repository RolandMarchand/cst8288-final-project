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
 * Data Access Object for maintenance alerts
 * 
 * @author roland
 */
public class MaintenanceAlertDAO {
    
    /**
     * Create a new maintenance alert
     * 
     * @param vehicleId The vehicle ID
     * @param alertType The type of alert
     * @param alertMessage The alert message
     * @param createdAt The creation timestamp
     * @return The ID of the newly created alert
     */
    public int createMaintenanceAlert(int vehicleId, String alertType, String alertMessage, LocalDateTime createdAt) {
        String sql = "INSERT INTO maintenance_alerts (vehicle_id, alert_type, alert_message, created_at, resolved) " +
                     "VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setInt(1, vehicleId);
            stmt.setString(2, alertType);
            stmt.setString(3, alertMessage);
            stmt.setTimestamp(4, Timestamp.valueOf(createdAt));
            stmt.setBoolean(5, false); // New alerts are not resolved
            
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Creating maintenance alert failed, no rows affected.");
            }
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating maintenance alert failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    /**
     * Get all maintenance alerts for a vehicle
     * 
     * @param vehicleId The vehicle ID
     * @param includeResolved Whether to include resolved alerts
     * @return A list of object arrays, each containing an alert's details
     */
    public List<Object[]> getMaintenanceAlertsForVehicle(int vehicleId, boolean includeResolved) {
        List<Object[]> alerts = new ArrayList<>();
        
        String sql = "SELECT * FROM maintenance_alerts WHERE vehicle_id = ?";
        if (!includeResolved) {
            sql += " AND resolved = FALSE";
        }
        sql += " ORDER BY created_at DESC";
        
        try (Connection conn = DataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, vehicleId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Object[] alert = new Object[7];
                    alert[0] = rs.getInt("alert_id");
                    alert[1] = rs.getInt("vehicle_id");
                    alert[2] = rs.getString("alert_type");
                    alert[3] = rs.getString("alert_message");
                    alert[4] = rs.getTimestamp("created_at").toLocalDateTime();
                    alert[5] = rs.getBoolean("resolved");
                    alert[6] = rs.getTimestamp("resolved_at") != null ? 
                              rs.getTimestamp("resolved_at").toLocalDateTime() : null;
                    alerts.add(alert);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return alerts;
    }
    
    /**
     * Get all active (unresolved) maintenance alerts
     * 
     * @return A list of object arrays, each containing an alert's details
     */
    public List<Object[]> getAllActiveMaintenanceAlerts() {
        List<Object[]> alerts = new ArrayList<>();
        String sql = "SELECT * FROM maintenance_alerts WHERE resolved = FALSE ORDER BY created_at DESC";
        
        try (Connection conn = DataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Object[] alert = new Object[7];
                alert[0] = rs.getInt("alert_id");
                alert[1] = rs.getInt("vehicle_id");
                alert[2] = rs.getString("alert_type");
                alert[3] = rs.getString("alert_message");
                alert[4] = rs.getTimestamp("created_at").toLocalDateTime();
                alert[5] = rs.getBoolean("resolved");
                alert[6] = rs.getTimestamp("resolved_at") != null ? 
                          rs.getTimestamp("resolved_at").toLocalDateTime() : null;
                alerts.add(alert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return alerts;
    }
    
    /**
     * Mark a maintenance alert as resolved
     * 
     * @param alertId The alert ID
     * @param resolvedAt The resolution timestamp
     * @return true if successful, false otherwise
     */
    public boolean resolveMaintenanceAlert(int alertId, LocalDateTime resolvedAt) {
        String sql = "UPDATE maintenance_alerts SET resolved = TRUE, resolved_at = ? WHERE alert_id = ?";
        
        try (Connection conn = DataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setTimestamp(1, Timestamp.valueOf(resolvedAt));
            stmt.setInt(2, alertId);
            
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Delete a maintenance alert
     * 
     * @param alertId The alert ID
     * @return true if successful, false otherwise
     */
    public boolean deleteMaintenanceAlert(int alertId) {
        String sql = "DELETE FROM maintenance_alerts WHERE alert_id = ?";
        
        try (Connection conn = DataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, alertId);
            
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
