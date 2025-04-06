package com.business.contract.vehicle.routeassignment;

import com.business.contract.controller.ObserverPattern;
import com.business.contract.vehicle.routes.TransitRouteBuilder;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Uses a STRATEGY pattern to assign a route to a given vehicle using its
 * setCurrentRouteAssignment() method based on user dashboard activity. Requires
 * observer notice to enable selectRouteOption.
 *
 * @author D. Santos
 */
public class RouteAssignment {

    public RouteAssignment() {
    }

    public ArrayList<JsonArray> transitStops;
    public ArrayList<String> transitRouteNames;

    public ArrayList<JsonArray> loadRouteInfo(ObserverPattern observer) throws IOException {

        TransitRouteBuilder transitRouteBuilder = new TransitRouteBuilder();
        transitRouteBuilder.loadTransitRoutes();
        transitStops = transitRouteBuilder.getTransitStops();
        transitRouteNames = transitRouteBuilder.getTransitRouteNames();

        return null;

    }

    /**
     * The getRoutes() method is called when the user selects a route
     * assignation dialog in the dashboard.
     *
     * @return transitRouteNames The list of transit route names from the
     * transit info file.
     */
    public ArrayList<String> getRoutes() {
        return transitRouteNames;

    }

    /**
     * The routeSelection method is activated when the user selects a route from
     * the user dashboard. The user selects a route, parses the ArrayList for
     * that route name, and add all its stops to a new ArrayList.
     *
     * @param routeName
     * @return
     */
    public ArrayList<JsonArray> routeSelection(String routeName) {
        ArrayList<JsonArray> returnRoute = new ArrayList<>();
        for (int i = 0; i < transitStops.size(); i++) {

            JsonArray pull = transitStops.get(i);
            JsonObject check = pull.getJsonObject(i);
            String routechk = check.keySet().iterator().next();
            if (routeName.equals(routechk)) {
                returnRoute.add(pull);
            }

        }
        return returnRoute;
    }

}
