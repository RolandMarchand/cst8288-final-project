package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Data Access Object for bus parts
 *
 * @author roland
 */
public class BusPartsDAO {

    /**
     * Create a new bus parts record
     *
     * @param vehicleId The vehicle ID to associate with these parts
     * @param brakesCondition The condition of the brakes
     * @param tiresCondition The condition of the tires
     * @param axleBearingACondition The condition of axle bearing A
     * @param axleBearingBCondition The condition of axle bearing B
     * @return The ID of the newly created bus parts record
     */
    public int createBusParts(int vehicleId, String brakesCondition, String tiresCondition,
            String axleBearingACondition, String axleBearingBCondition) {

        String sql = "INSERT INTO bus_parts (vehicle_id, brakes_condition, tires_condition, "
                + "axle_bearing_a_condition, axle_bearing_b_condition) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, vehicleId);
            stmt.setString(2, brakesCondition);
            stmt.setString(3, tiresCondition);
            stmt.setString(4, axleBearingACondition);
            stmt.setString(5, axleBearingBCondition);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating bus parts failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating bus parts failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Get bus parts by vehicle ID
     *
     * @param vehicleId The vehicle ID
     * @return An array of strings containing the bus parts details
     */
    public String[] getBusPartsByVehicleId(int vehicleId) {
        String sql = "SELECT * FROM bus_parts WHERE vehicle_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String[] busParts = new String[6];
                    busParts[0] = String.valueOf(rs.getInt("bus_parts_id"));
                    busParts[1] = String.valueOf(rs.getInt("vehicle_id"));
                    busParts[2] = rs.getString("brakes_condition");
                    busParts[3] = rs.getString("tires_condition");
                    busParts[4] = rs.getString("axle_bearing_a_condition");
                    busParts[5] = rs.getString("axle_bearing_b_condition");
                    return busParts;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Update bus parts
     *
     * @param busPartsId The bus parts ID
     * @param brakesCondition The condition of the brakes
     * @param tiresCondition The condition of the tires
     * @param axleBearingACondition The condition of axle bearing A
     * @param axleBearingBCondition The condition of axle bearing B
     * @return true if successful, false otherwise
     */
    public boolean updateBusParts(int busPartsId, String brakesCondition, String tiresCondition,
            String axleBearingACondition, String axleBearingBCondition) {

        String sql = "UPDATE bus_parts SET brakes_condition = ?, tires_condition = ?, "
                + "axle_bearing_a_condition = ?, axle_bearing_b_condition = ? "
                + "WHERE bus_parts_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, brakesCondition);
            stmt.setString(2, tiresCondition);
            stmt.setString(3, axleBearingACondition);
            stmt.setString(4, axleBearingBCondition);
            stmt.setInt(5, busPartsId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Update bus parts by vehicle ID
     *
     * @param vehicleId The vehicle ID
     * @param brakesCondition The condition of the brakes
     * @param tiresCondition The condition of the tires
     * @param axleBearingACondition The condition of axle bearing A
     * @param axleBearingBCondition The condition of axle bearing B
     * @return true if successful, false otherwise
     */
    public boolean updateBusPartsByVehicleId(int vehicleId, String brakesCondition, String tiresCondition,
            String axleBearingACondition, String axleBearingBCondition) {

        String sql = "UPDATE bus_parts SET brakes_condition = ?, tires_condition = ?, "
                + "axle_bearing_a_condition = ?, axle_bearing_b_condition = ? "
                + "WHERE vehicle_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, brakesCondition);
            stmt.setString(2, tiresCondition);
            stmt.setString(3, axleBearingACondition);
            stmt.setString(4, axleBearingBCondition);
            stmt.setInt(5, vehicleId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete bus parts by ID
     *
     * @param busPartsId The bus parts ID
     * @return true if successful, false otherwise
     */
    public boolean deleteBusParts(int busPartsId) {
        String sql = "DELETE FROM bus_parts WHERE bus_parts_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, busPartsId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete bus parts by vehicle ID
     *
     * @param vehicleId The vehicle ID
     * @return true if successful, false otherwise
     */
    public boolean deleteBusPartsByVehicleId(int vehicleId) {
        String sql = "DELETE FROM bus_parts WHERE vehicle_id = ?";

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
