package dataaccess;

import com.business.contract.controller.MediatorContract;
import com.business.contract.controller.MediatorEvent;
import com.business.contract.controller.VehicleRegistrationMediatorEvent;
import static java.lang.Double.parseDouble;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 * Data Access Object for the vehicles table
 *
 * @author roland
 */
public class VehicleDAO implements MediatorContract {

    /**
     * Create a new vehicle in the database
     *
     * @param registrationNumber The vehicle's registration number
     * @param vehicleTypeId The vehicle's type ID
     * @param fuelEnergyTypeId The vehicle's fuel/energy type ID
     * @param consumptionRate The vehicle's consumption rate
     * @param maxPassengers The vehicle's maximum passenger capacity
     * @param currentRouteId The vehicle's current route ID (can be null)
     * @return The ID of the newly created vehicle
     */
    public int createVehicle(String registrationNumber, String vehicleTypeId,
            String fuelEnergyTypeId, double consumptionRate,
            int maxPassengers, Integer currentRouteId) {

        String sql = "INSERT INTO vehicles (registration_number, vehicle_type_id, "
                + "fuel_energy_type_id, consumption_rate, max_passengers, current_route_id) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, registrationNumber);
            stmt.setString(2, vehicleTypeId);
            stmt.setString(3, fuelEnergyTypeId);
            stmt.setDouble(4, consumptionRate);
            stmt.setInt(5, maxPassengers);

            if (currentRouteId != null) {
                stmt.setInt(6, currentRouteId);
            } else {
                stmt.setNull(6, java.sql.Types.INTEGER);
            }

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating vehicle failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating vehicle failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Get a vehicle by its ID
     *
     * @param vehicleId The vehicle's ID
     * @return An array of strings containing the vehicle's details
     */
    public String[] getVehicleById(int vehicleId) {
        String sql = "SELECT * FROM vehicles WHERE vehicle_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String[] vehicle = new String[7];
                    vehicle[0] = String.valueOf(rs.getInt("vehicle_id"));
                    vehicle[1] = rs.getString("registration_number");
                    vehicle[2] = rs.getString("vehicle_type_id");
                    vehicle[3] = rs.getString("fuel_energy_type_id");
                    vehicle[4] = String.valueOf(rs.getDouble("consumption_rate"));
                    vehicle[5] = String.valueOf(rs.getInt("max_passengers"));
                    vehicle[6] = rs.getObject("current_route_id") != null
                            ? String.valueOf(rs.getInt("current_route_id")) : null;
                    return vehicle;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get a vehicle by its registration number
     *
     * @param registrationNumber The vehicle's registration number
     * @return An array of strings containing the vehicle's details
     */
    public String[] getVehicleByRegistrationNumber(String registrationNumber) {
        String sql = "SELECT * FROM vehicles WHERE registration_number = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, registrationNumber);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String[] vehicle = new String[7];
                    vehicle[0] = String.valueOf(rs.getInt("vehicle_id"));
                    vehicle[1] = rs.getString("registration_number");
                    vehicle[2] = rs.getString("vehicle_type_id");
                    vehicle[3] = rs.getString("fuel_energy_type_id");
                    vehicle[4] = String.valueOf(rs.getDouble("consumption_rate"));
                    vehicle[5] = String.valueOf(rs.getInt("max_passengers"));
                    vehicle[6] = rs.getObject("current_route_id") != null
                            ? String.valueOf(rs.getInt("current_route_id")) : null;
                    return vehicle;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get all vehicles
     *
     * @return A list of string arrays, each containing a vehicle's details
     */
    public List<String[]> getAllVehicles() {
        List<String[]> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";

        try (Connection conn = DataSource.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String[] vehicle = new String[7];
                vehicle[0] = String.valueOf(rs.getInt("vehicle_id"));
                vehicle[1] = rs.getString("registration_number");
                vehicle[2] = rs.getString("vehicle_type_id");
                vehicle[3] = rs.getString("fuel_energy_type_id");
                vehicle[4] = String.valueOf(rs.getDouble("consumption_rate"));
                vehicle[5] = String.valueOf(rs.getInt("max_passengers"));
                vehicle[6] = rs.getObject("current_route_id") != null
                        ? String.valueOf(rs.getInt("current_route_id")) : null;
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    /**
     * Update a vehicle
     *
     * @param vehicleId The vehicle's ID
     * @param registrationNumber The vehicle's registration number
     * @param vehicleTypeId The vehicle's type ID
     * @param fuelEnergyTypeId The vehicle's fuel/energy type ID
     * @param consumptionRate The vehicle's consumption rate
     * @param maxPassengers The vehicle's maximum passenger capacity
     * @param currentRouteId The vehicle's current route ID (can be null)
     * @return true if successful, false otherwise
     */
    public boolean updateVehicle(int vehicleId, String registrationNumber,
            String vehicleTypeId, String fuelEnergyTypeId,
            double consumptionRate, int maxPassengers,
            Integer currentRouteId) {

        String sql = "UPDATE vehicles SET registration_number = ?, vehicle_type_id = ?, "
                + "fuel_energy_type_id = ?, consumption_rate = ?, max_passengers = ?, "
                + "current_route_id = ? WHERE vehicle_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, registrationNumber);
            stmt.setString(2, vehicleTypeId);
            stmt.setString(3, fuelEnergyTypeId);
            stmt.setDouble(4, consumptionRate);
            stmt.setInt(5, maxPassengers);

            if (currentRouteId != null) {
                stmt.setInt(6, currentRouteId);
            } else {
                stmt.setNull(6, java.sql.Types.INTEGER);
            }

            stmt.setInt(7, vehicleId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Update a vehicle's route assignment
     *
     * @param vehicleId The vehicle's ID
     * @param routeId The new route ID (can be null to unassign)
     * @return true if successful, false otherwise
     */
    public boolean updateVehicleRoute(int vehicleId, Integer routeId) {
        String sql = "UPDATE vehicles SET current_route_id = ? WHERE vehicle_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (routeId != null) {
                stmt.setInt(1, routeId);
            } else {
                stmt.setNull(1, java.sql.Types.INTEGER);
            }

            stmt.setInt(2, vehicleId);

            int affectedRows = stmt.executeUpdate();

            // Also record in the route assignment history
            if (affectedRows > 0 && routeId != null) {
                recordRouteAssignment(vehicleId, routeId);
            } else if (affectedRows > 0 && routeId == null) {
                completeRouteAssignment(vehicleId);
            }

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Record a new route assignment in the history table
     *
     * @param vehicleId The vehicle's ID
     * @param routeId The new route ID
     */
    private void recordRouteAssignment(int vehicleId, int routeId) {
        String sql = "INSERT INTO route_assignment_history (vehicle_id, route_id, assigned_at) "
                + "VALUES (?, ?, NOW())";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleId);
            stmt.setInt(2, routeId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Complete a route assignment in the history table
     *
     * @param vehicleId The vehicle's ID
     */
    private void completeRouteAssignment(int vehicleId) {
        String sql = "UPDATE route_assignment_history SET unassigned_at = NOW() "
                + "WHERE vehicle_id = ? AND unassigned_at IS NULL";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete a vehicle
     *
     * @param vehicleId The vehicle's ID
     * @return true if successful, false otherwise
     */
    public boolean deleteVehicle(int vehicleId) {
        String sql = "DELETE FROM vehicles WHERE vehicle_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void sendEvent(MediatorEvent mediatorEvent) {

    }

    @Override
    public void receiveEvent(MediatorEvent mediatorEvent) {
        handleIncomingEvent(mediatorEvent);

    }

    public void handleIncomingEvent(MediatorEvent mediatorEvent) {
        String registrationNumber;
        String vehicleTypeId;
        String fuelEnergyTypeId;
        double consumptionRate;
        int maxPassengers;
        Integer currentRouteId;

        VehicleRegistrationMediatorEvent vehicleDetails = (VehicleRegistrationMediatorEvent) mediatorEvent;
        HttpServletRequest request = vehicleDetails.getRequest();
        registrationNumber = request.getParameter("vehicleNumber");
        vehicleTypeId = request.getParameter("vehicleType");
        fuelEnergyTypeId = request.getParameter("fuelType");
        consumptionRate = Double.parseDouble(request.getParameter("consumptionRate"));
        maxPassengers = Integer.parseInt(request.getParameter("maxPassengers"));
         //TODO: Implement route assignation in presentation layer.
        currentRouteId = Integer.parseInt(request.getParameter(""));
        createVehicle(registrationNumber, vehicleTypeId, fuelEnergyTypeId,consumptionRate, maxPassengers, currentRouteId);
    }
}
