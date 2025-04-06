/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicle.routes;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * The TransitStop class takes a delimited text file of route titles, stop
 * names, latitude and longitude coordinates, and parses the file to generate an
 * ArrayList of String objects containing the data. It also creates a list of
 * route names for the dashboard. When completed, an OBSERVER is alerted, so
 * that the Route Assignment menu can be populated for the user.
 *
 * @author D.Santos
 */
public class TransitRouteBuilder {

    public TransitRouteBuilder() {
    }

    public ArrayList<String[]> transitStops = new ArrayList<String[]>();

    /**
     *
     */
    public ArrayList<String> transitRouteNames = new ArrayList<String>();
    
    public ArrayList<String[]> getTransitStops(){
        return transitStops;
    }
    
      public ArrayList<String> getTransitRouteNames(){
        return transitRouteNames;
    }

    /**
     * Parses the transit stops file , builds up the variables, and writes a
     * String[] object to the transitStops array. 
     * @throws IOException
     */
    public void loadTransitRoutes() throws IOException {

        Path basePath = Paths.get("/cst8288-final-project");
        Path relativePath = Paths.get("/src/main/resources/routes.txt");
        Path basePathToPath = basePath.relativize(relativePath);
        String line;
        String[] routeStringManager;
        String transitRoute = null;
        String transitStopName = null;
        String transitStopLat = null;
        String transitStopLong = null;

        try (InputStream input = Files.newInputStream(basePathToPath); BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            while ((line = reader.readLine()) != null) {
                if (!line.contains("|")) {
                    transitRoute = line;
                } else if (line.contains("|") && line != null) {
                    routeStringManager = line.split("|");
                    transitStopName = routeStringManager[0];
                    transitStopLat = routeStringManager[1];
                    transitStopLong = routeStringManager[2];
                }
            }
            if (reader.readLine() == null) {
                transitStops.add(buildTransitRoute(transitRoute, transitStopName, transitStopLat, transitStopLong));
                transitRouteNames.add(transitRoute);
            }
        }
        //TODO: Alert Observer.
    }

    /**
     * Make a String[] object out of a transitRoute.
     *
     * @param transitRoute
     * @param transitStopName
     * @param transitStopLat
     * @param transitStopLong
     * @return transitRoute
     */
    public String[] buildTransitRoute(String transitRoute, String transitStopName, String transitStopLat, String transitStopLong) {
        String[] transitStop = new String[4];
       
        transitStop[0] = transitRoute;
          transitStop[1] = transitStopName;
            transitStop[2] = transitStopLat;
              transitStop[3] = transitStopLong;
        
        return transitStop;
    }
}
