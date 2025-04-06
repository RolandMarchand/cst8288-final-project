/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.launcher;

import com.business.contract.vehicle.routes.TransitRouteBuilder;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author drssa
 */
public class launcher {

    public static void main(String args[]) throws IOException {

        TransitRouteBuilder transitStop2 = new TransitRouteBuilder();
        transitStop2.loadTransitRoutes();

        ArrayList<JsonArray> test2 = new ArrayList<JsonArray>();
        JsonArray test1 = test2.get(0);

        JsonObject zilch = test1.getJsonObject(0);
        String zilch2 = zilch.getString("stopName");
        System.out.println(zilch2);

    }
}
