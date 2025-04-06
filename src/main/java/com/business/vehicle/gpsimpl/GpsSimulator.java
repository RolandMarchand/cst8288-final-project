/*
 * Synchronization example credited to Baeldung. https://www.baeldung.com/java-wait-notify
 */
package com.business.vehicle.gpsimpl;


import com.business.contract.controller.VehicleRegistrationMediator;
import com.business.contract.vehicle.gps.GPSOdometerContract;
import java.util.HashMap;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author D. Santos
 */
public class GpsSimulator implements GPSOdometerContract {

    private String vehicleClockTime;
    private boolean vehicleRunning = false;

    public boolean useFuel = false;

    String vehicleLattitude;
    String vehicleLongitude;

    public double fuelTank = 100.00;
    HashMap fuelEfficiencyChart;
    Double fuelConsumptionRate;
    Double fuelEfficiencyPercentage;
    boolean fuelWarningAlert = false;

    public GpsSimulator() {
        gpsOverallCoordinator();
    }

    @Override
    public void gpsOverallCoordinator() {
        simulateClockTime();
        simulateVehicleActivity(vehicleRunning);

        while (vehicleRunning) {
            simulateVehicleLattitude(vehicleRunning);
            simulateVehicleLongitude(vehicleRunning);
            simulateFuelEnergyLevel(useFuel, fuelTank);
            calculateFuelEfficiency(vehicleRunning, fuelEfficiencyChart, fuelConsumptionRate);
            sendFuelAlert(vehicleRunning, fuelEfficiencyPercentage);
        }

    }

    @Override
    public synchronized void simulateVehicleActivity(boolean vehicleRunning) {
        boolean vehicleStarted = vehicleRunning;
        String activityState;
        while (vehicleStarted) {
            Random random = new Random();
            int drivingStatus = random.nextInt(2);
            if (drivingStatus == 1) {
                activityState = "Moving";
                vehicleStarted = true;
                this.useFuel = true;

            } else if (drivingStatus == 2) {
                activityState = "Stopped";
                vehicleStarted = false;
                this.useFuel = false;
            }
            int waitTime = random.nextInt(30, 45);
            try {
                wait(waitTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("VehicleActivity thread Interrupted");
            }
            notifyAll();
            this.vehicleRunning = vehicleStarted;
        }
    }

    @Override
    public synchronized void simulateVehicleLattitude(boolean vehicleRunning) {
        boolean simulateLattitude = vehicleRunning;
        Random random = new Random();
        String lattitude;
        while (simulateLattitude) {
            lattitude = (random.doubles(45.1789, 45.5177)).toString();
            try {
                wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("simulateVehicleLattitude() thread interrupted");
            }
            notifyAll();
            this.vehicleLattitude = lattitude;
        }

    }

    @Override
    public synchronized void simulateVehicleLongitude(boolean vehicleRunning) {
        boolean simulateLongitude = vehicleRunning;
        Random random = new Random();
        String longitude;
        while (simulateLongitude) {
            longitude = (random.doubles(-76.1658, -75.4078)).toString();
            try {
                wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("simulateVehicleLlongitude() thread interrupted");
            }
            this.vehicleLongitude = longitude;
            notifyAll();
        }
    }

    @Override
    public synchronized void simulateClockTime() {
        String dateTime;
        Random random = new Random();

        boolean timeClock = true;

        while (timeClock) {
            dateTime = (LocalDateTime.now()).toString();
            try {
                wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("ClockTime thread interrupted.");
            }
            this.vehicleClockTime = dateTime;
            notifyAll();

        }
    }

    @Override
    public synchronized void simulateFuelEnergyLevel(boolean useFuel, double fuelTank) {
        boolean fuelBeingUsed = useFuel;
        Random random = new Random();

        double theFuelConsumptionRate = random.nextDouble(0.3, 1.3);

        double fuelUse = fuelTank;

        while (fuelBeingUsed) {
            fuelUse = fuelUse - (1.0 * theFuelConsumptionRate);
            Double fuelUse2 = fuelUse;
            try {
                wait(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("FuelEnergy thread interrupted.");
            }
            this.fuelTank = fuelUse2;
            this.fuelConsumptionRate = theFuelConsumptionRate;
            notifyAll();

        }
    }

    @Override
    public synchronized void calculateFuelEfficiency(boolean vehicleRunning, HashMap fuelChart, double fuelConsumptionRate) {
        boolean calcFuelEfficiency = vehicleRunning;
        double fuelBurnRate = fuelConsumptionRate;
        HashMap fuelEfficiencyCalc = fuelChart;
        int mapKeyCounter = 1;
        while (calcFuelEfficiency) {
            if (mapKeyCounter == 30) {
                mapKeyCounter = 1;
            }
            while (calcFuelEfficiency) {
                fuelEfficiencyCalc.put(mapKeyCounter, fuelBurnRate);
                mapKeyCounter = mapKeyCounter + 1;
            }
            try {
                wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("calculateFuelEffiency() thread interrupted.");
            }
            this.fuelEfficiencyChart = fuelEfficiencyCalc;
            //TODO: write method to calculate fuelEfficiencyPercentage from HashMap.
            notifyAll();

        }
    }

    @Override
    public synchronized void sendFuelAlert(boolean vehicleRunning, double fuelEfficiencyPercentage) {
        boolean isRunning = vehicleRunning;
        double fuelRate = fuelEfficiencyPercentage;

        while (isRunning) {
            if (fuelRate > .8) {

                this.fuelWarningAlert = true;

                try {
                    wait(10000);
                    this.fuelWarningAlert = false;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("sendFuelAlert() thread interrupted.");
                }
                //TODO: write method to calculate fuelEfficiencyPercentage from HashMap.
                notifyAll();

            }
        }
    }

    @Override
    public void notifySender(VehicleRegistrationMediator mediatorEvent) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void notifyReceiver(VehicleRegistrationMediator mediatorEvent) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
