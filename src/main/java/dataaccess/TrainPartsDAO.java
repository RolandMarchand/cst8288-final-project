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

/**
 * Data Access Object for train parts
 *
 * @author roland
 */
public class TrainPartsDAO {

    /**
     * Create a new train parts record
     *
     * @param vehicleId The vehicle ID to associate with these parts
     * @param catenaryCondition The condition of the catenary
     * @param pantographCondition The condition of the pantograph
     * @param circuitBreakerCondition The condition of the circuit breaker
     * @return The ID of the newly created train parts record
     */
    public int createTrainParts(int vehicleId, String catenaryCondition,
            String pantographCondition, String circuitBreakerCondition) {

        String sql = "INSERT INTO train_parts (vehicle_id, catenary_condition, "
                + "pantograph_condition, circuit_breaker_condition) VALUES (?, ?, ?, ?)";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, vehicleId);
            stmt.setString(2, catenaryCondition);
            stmt.setString(3, pantographCondition);
            stmt.setString(4, circuitBreakerCondition);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating train parts failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating train parts failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Get train parts by vehicle ID
     *
     * @param vehicleId The vehicle ID
     * @return An array of strings containing the train parts details
     */
    public String[] getTrainPartsByVehicleId(int vehicleId) {
        String sql = "SELECT * FROM train_parts WHERE vehicle_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String[] trainParts = new String[5];
                    trainParts[0] = String.valueOf(rs.getInt("train_parts_id"));
                    trainParts[1] = String.valueOf(rs.getInt("vehicle_id"));
                    trainParts[2] = rs.getString("catenary_condition");
                    trainParts[3] = rs.getString("pantograph_condition");
                    trainParts[4] = rs.getString("circuit_breaker_condition");
                    return trainParts;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Update train parts
     *
     * @param trainPartsId The train parts ID
     * @param catenaryCondition The condition of the catenary
     * @param pantographCondition The condition of the pantograph
     * @param circuitBreakerCondition The condition of the circuit breaker
     * @return true if successful, false otherwise
     */
    public boolean updateTrainParts(int trainPartsId, String catenaryCondition,
            String pantographCondition, String circuitBreakerCondition) {

        String sql = "UPDATE train_parts SET catenary_condition = ?, "
                + "pantograph_condition = ?, circuit_breaker_condition = ? "
                + "WHERE train_parts_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, catenaryCondition);
            stmt.setString(2, pantographCondition);
            stmt.setString(3, circuitBreakerCondition);
            stmt.setInt(4, trainPartsId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Update train parts by vehicle ID
     *
     * @param vehicleId The vehicle ID
     * @param catenaryCondition The condition of the catenary
     * @param pantographCondition The condition of the pantograph
     * @param circuitBreakerCondition The condition of the circuit breaker
     * @return true if successful, false otherwise
     */
    public boolean updateTrainPartsByVehicleId(int vehicleId, String catenaryCondition,
            String pantographCondition, String circuitBreakerCondition) {

        String sql = "UPDATE train_parts SET catenary_condition = ?, "
                + "pantograph_condition = ?, circuit_breaker_condition = ? "
                + "WHERE vehicle_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, catenaryCondition);
            stmt.setString(2, pantographCondition);
            stmt.setString(3, circuitBreakerCondition);
            stmt.setInt(4, vehicleId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete train parts by ID
     *
     * @param trainPartsId The train parts ID
     * @return true if successful, false otherwise
     */
    public boolean deleteTrainParts(int trainPartsId) {
        String sql = "DELETE FROM train_parts WHERE train_parts_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, trainPartsId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete train parts by vehicle ID
     *
     * @param vehicleId The vehicle ID
     * @return true if successful, false otherwise
     */
    public boolean deleteTrainPartsByVehicleId(int vehicleId) {
        String sql = "DELETE FROM train_parts WHERE vehicle_id = ?";

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
