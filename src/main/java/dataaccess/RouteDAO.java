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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data Access Object for routes and stops
 *
 * @author roland
 */
public class RouteDAO {

    /**
     * Create a new route
     *
     * @param routeName The route name
     * @return The ID of the newly created route
     */
    public int createRoute(String routeName) {
        String sql = "INSERT INTO routes (route_name) VALUES (?)";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, routeName);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating route failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating route failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Get a route by ID
     *
     * @param routeId The route ID
     * @return An array of strings containing the route details
     */
    public String[] getRouteById(int routeId) {
        String sql = "SELECT * FROM routes WHERE route_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, routeId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String[] route = new String[2];
                    route[0] = String.valueOf(rs.getInt("route_id"));
                    route[1] = rs.getString("route_name");
                    return route;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get all routes
     *
     * @return A list of string arrays, each containing a route's details
     */
    public List<String[]> getAllRoutes() {
        List<String[]> routes = new ArrayList<>();
        String sql = "SELECT * FROM routes";

        try (Connection conn = DataSource.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String[] route = new String[2];
                route[0] = String.valueOf(rs.getInt("route_id"));
                route[1] = rs.getString("route_name");
                routes.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return routes;
    }

    /**
     * Update a route
     *
     * @param routeId The route ID
     * @param routeName The new route name
     * @return true if successful, false otherwise
     */
    public boolean updateRoute(int routeId, String routeName) {
        String sql = "UPDATE routes SET route_name = ? WHERE route_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, routeName);
            stmt.setInt(2, routeId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete a route
     *
     * @param routeId The route ID
     * @return true if successful, false otherwise
     */
    public boolean deleteRoute(int routeId) {
        // First delete any route_stops entries for this route
        String deleteRouteStopsSql = "DELETE FROM route_stops WHERE route_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(deleteRouteStopsSql)) {

            stmt.setInt(1, routeId);
            stmt.executeUpdate();

            // Then delete the route itself
            String deleteRouteSql = "DELETE FROM routes WHERE route_id = ?";

            try (PreparedStatement stmt2 = conn.prepareStatement(deleteRouteSql)) {
                stmt2.setInt(1, routeId);
                int affectedRows = stmt2.executeUpdate();
                return affectedRows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Create a new stop
     *
     * @param stopName The stop name
     * @param latitude The stop latitude
     * @param longitude The stop longitude
     * @return The ID of the newly created stop
     */
    public int createStop(String stopName, double latitude, double longitude) {
        String sql = "INSERT INTO stops (stop_name, latitude, longitude) VALUES (?, ?, ?)";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, stopName);
            stmt.setDouble(2, latitude);
            stmt.setDouble(3, longitude);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating stop failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating stop failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Get a stop by ID
     *
     * @param stopId The stop ID
     * @return An array of strings containing the stop details
     */
    public String[] getStopById(int stopId) {
        String sql = "SELECT * FROM stops WHERE stop_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, stopId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String[] stop = new String[4];
                    stop[0] = String.valueOf(rs.getInt("stop_id"));
                    stop[1] = rs.getString("stop_name");
                    stop[2] = String.valueOf(rs.getDouble("latitude"));
                    stop[3] = String.valueOf(rs.getDouble("longitude"));
                    return stop;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get all stops
     *
     * @return A list of string arrays, each containing a stop's details
     */
    public List<String[]> getAllStops() {
        List<String[]> stops = new ArrayList<>();
        String sql = "SELECT * FROM stops";

        try (Connection conn = DataSource.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String[] stop = new String[4];
                stop[0] = String.valueOf(rs.getInt("stop_id"));
                stop[1] = rs.getString("stop_name");
                stop[2] = String.valueOf(rs.getDouble("latitude"));
                stop[3] = String.valueOf(rs.getDouble("longitude"));
                stops.add(stop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stops;
    }

    /**
     * Update a stop
     *
     * @param stopId The stop ID
     * @param stopName The new stop name
     * @param latitude The new latitude
     * @param longitude The new longitude
     * @return true if successful, false otherwise
     */
    public boolean updateStop(int stopId, String stopName, double latitude, double longitude) {
        String sql = "UPDATE stops SET stop_name = ?, latitude = ?, longitude = ? WHERE stop_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, stopName);
            stmt.setDouble(2, latitude);
            stmt.setDouble(3, longitude);
            stmt.setInt(4, stopId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete a stop
     *
     * @param stopId The stop ID
     * @return true if successful, false otherwise
     */
    public boolean deleteStop(int stopId) {
        // First delete any route_stops entries for this stop
        String deleteRouteStopsSql = "DELETE FROM route_stops WHERE stop_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(deleteRouteStopsSql)) {

            stmt.setInt(1, stopId);
            stmt.executeUpdate();

            // Then delete the stop itself
            String deleteStopSql = "DELETE FROM stops WHERE stop_id = ?";

            try (PreparedStatement stmt2 = conn.prepareStatement(deleteStopSql)) {
                stmt2.setInt(1, stopId);
                int affectedRows = stmt2.executeUpdate();
                return affectedRows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Add a stop to a route
     *
     * @param routeId The route ID
     * @param stopId The stop ID
     * @param stopSequence The sequence number of the stop on the route
     * @return true if successful, false otherwise
     */
    public boolean addStopToRoute(int routeId, int stopId, int stopSequence) {
        String sql = "INSERT INTO route_stops (route_id, stop_id, stop_sequence) VALUES (?, ?, ?)";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, routeId);
            stmt.setInt(2, stopId);
            stmt.setInt(3, stopSequence);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Remove a stop from a route
     *
     * @param routeId The route ID
     * @param stopId The stop ID
     * @return true if successful, false otherwise
     */
    public boolean removeStopFromRoute(int routeId, int stopId) {
        String sql = "DELETE FROM route_stops WHERE route_id = ? AND stop_id = ?";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, routeId);
            stmt.setInt(2, stopId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get all stops for a route
     *
     * @param routeId The route ID
     * @return A map of stop sequence numbers to stop details
     */
    public Map<Integer, String[]> getStopsForRoute(int routeId) {
        Map<Integer, String[]> stops = new HashMap<>();
        String sql = "SELECT s.*, rs.stop_sequence FROM stops s "
                + "JOIN route_stops rs ON s.stop_id = rs.stop_id "
                + "WHERE rs.route_id = ? "
                + "ORDER BY rs.stop_sequence";

        try (Connection conn = DataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, routeId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String[] stop = new String[4];
                    stop[0] = String.valueOf(rs.getInt("stop_id"));
                    stop[1] = rs.getString("stop_name");
                    stop[2] = String.valueOf(rs.getDouble("latitude"));
                    stop[3] = String.valueOf(rs.getDouble("longitude"));

                    int stopSequence = rs.getInt("stop_sequence");
                    stops.put(stopSequence, stop);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stops;
    }
}
