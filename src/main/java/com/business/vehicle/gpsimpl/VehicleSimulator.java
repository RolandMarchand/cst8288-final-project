/*
 * Synchronization example credited to Baeldung. https://www.baeldung.com/java-wait-notify
 */
package com.business.vehicle.gpsimpl;

import com.business.contract.controller.VehicleRegistrationMediator;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.Random;
import com.business.contract.vehicle.gps.VehicleSimulatorContract;

/**
 * This class simulates a vehicle's GPS and fuel systems, including tracking 
 * latitude, longitude, clock time, fuel usage, and vehicle activity.
 * It synchronizes the various threads responsible for simulating vehicle activity
 * and provides methods for calculating fuel efficiency and sending alerts when fuel is low.
 * Implements link VehicleSimulatorContract
 * 
 * @author D. Santos
 */
public class VehicleSimulator implements VehicleSimulatorContract {

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

    /**
     * Default constructor that initializes the GPS and vehicle activity simulation.
     */
    public VehicleSimulator() {
        gpsOverallCoordinator();
    }

    /**
     * Coordinates the overall simulation by initiating the clock time and vehicle activity.
     * This method runs the simulation as long as the vehicle is running.
     */
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

    /**
     * Simulates the vehicle's activity by randomly determining whether the vehicle 
     * is running or stopped. It also determines if fuel is being used.
     * 
     * @param vehicleRunning boolean flag indicating if the vehicle is running
     */
    @Override
    public synchronized void simulateVehicleActivity(boolean vehicleRunning) {
        boolean vehicleStarted = vehicleRunning;

        while (vehicleStarted) {
            Random random = new Random();
            int drivingStatus = random.nextInt(2);
            if (drivingStatus == 1) {
                vehicleStarted = true;
                this.useFuel = true;
            } else if (drivingStatus == 2) {
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
            this.vehicleRunning = vehicleStarted;
        }
    }

    /**
     * Simulates the vehicle's latitude by randomly generating a value within a 
     * defined range and updating the vehicle's latitude.
     * 
     * @param vehicleRunning boolean flag indicating if the vehicle is running
     */
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
            this.vehicleLattitude = lattitude;
        }
    }

    /**
     * Simulates the vehicle's longitude by randomly generating a value within a 
     * defined range and updating the vehicle's longitude.
     * 
     * @param vehicleRunning boolean flag indicating if the vehicle is running
     */
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
        }
    }

    /**
     * Simulates the vehicle's clock time by updating the vehicleClockTime at 
     * regular intervals.
     */
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
        }
    }

    /**
     * Simulates the vehicle's fuel energy level by adjusting the fuel tank 
     * level based on the fuel consumption rate.
     * 
     * @param useFuel boolean flag indicating if fuel is being used
     * @param fuelTank the current fuel level of the vehicle
     */
    @Override
    public synchronized void simulateFuelEnergyLevel(boolean useFuel, double fuelTank) {
        boolean fuelBeingUsed = useFuel;
        double fuelUse = fuelTank;
        
        Random random = new Random();

        double theFuelConsumptionRate = random.nextDouble(0.3, 1.3);

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
        }
    }

    /**
     * Calculates the vehicle's fuel efficiency based on the fuel consumption 
     * rate and stores it in the fuelEfficiencyChart.
     * 
     * @param vehicleRunning boolean flag indicating if the vehicle is running
     * @param fuelChart the fuel efficiency chart to be updated
     * @param fuelConsumptionRate the current rate of fuel consumption
     */
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
        }
    }

    /**
     * Sends a fuel warning alert if the fuel efficiency percentage exceeds a certain threshold.
     * 
     * @param vehicleRunning boolean flag indicating if the vehicle is running
     * @param fuelEfficiencyPercentage the current fuel efficiency percentage
     */
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
            }
        }
    }

    /**
     * Placeholder method for handling events related to vehicle registration.
     * 
     * @param mediatorEvent the event related to vehicle registration
     */
    @Override
    public void sendEvent(VehicleRegistrationMediator mediatorEvent) {
    }

    /**
     * Placeholder method for receiving events related to vehicle registration.
     * 
     * @param mediatorEvent the event related to vehicle registration
     */
    @Override
    public void receiveEvent(VehicleRegistrationMediator mediatorEvent) {
    }

    /**
     * Placeholder method for processing a vehicle registration event.
     * 
     * @param mediatorEvent the event related to vehicle registration
     * @return a string result of the registration process
     */
    @Override
    public String processVehicleRegistration(VehicleRegistrationMediator mediatorEvent) {
        return null;
    }
}
