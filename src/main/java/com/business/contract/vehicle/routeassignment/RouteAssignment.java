package com.business.contract.vehicle.routeassignment;

import com.business.contract.controller.ObserverPattern;
import com.business.contract.vehicle.routes.TransitRouteBuilder;
import java.io.IOException;
import java.util.ArrayList;

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

    public ArrayList<String[]> transitStops;
    public ArrayList<String> transitRouteNames;

    /**
     * Loads the route information using the TransitRouteBuilder and updates 
     * the lists of transit stops and route names.
     * 
     * @param observer the ObserverPattern object to notify when routes are loaded
     * @return null (Currently returns null, can be updated to return the loaded route data)
     * @throws IOException if an error occurs while loading transit routes
     */
    public ArrayList<String[]> loadRouteInfo(ObserverPattern observer) throws IOException {

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
     * @param routeName the name of the route selected by the user
     * @return an ArrayList of String arrays containing the stops of the selected route
     */
    public ArrayList<String[]> routeSelection(String routeName) {
        ArrayList<String[]> returnRoute;
        returnRoute = new ArrayList<String[]>();
        String[] routeChecker = new String[4];
        for (int i = 0; i < transitStops.size(); i++) {
            routeChecker = transitStops.get(i);
            if (routeChecker[0].equals(routeName)) {

                returnRoute.add(routeChecker);

            }
        }
        return returnRoute;
    }
}
