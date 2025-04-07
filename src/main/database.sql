DROP DATABASE IF EXISTS ptfms;
CREATE DATABASE ptfms;
USE ptfms;

-- Vehicle Types table
CREATE TABLE vehicle_types (
    type_id VARCHAR(20) PRIMARY KEY,
    description VARCHAR(100)
);

-- Fuel/Energy Types table
CREATE TABLE fuel_energy_types (
    energy_id VARCHAR(20) PRIMARY KEY,
    description VARCHAR(100)
);

-- Vehicles table
CREATE TABLE vehicles (
    vehicle_id INT AUTO_INCREMENT PRIMARY KEY,
    registration_number VARCHAR(20) UNIQUE NOT NULL,
    vehicle_type_id VARCHAR(20) NOT NULL,
    fuel_energy_type_id VARCHAR(20) NOT NULL,
    consumption_rate DECIMAL(10,2) NOT NULL,
    max_passengers INT NOT NULL,
    current_route_id INT,
    FOREIGN KEY (vehicle_type_id) REFERENCES vehicle_types(type_id),
    FOREIGN KEY (fuel_energy_type_id) REFERENCES fuel_energy_types(energy_id)
);

-- Bus Parts table
CREATE TABLE bus_parts (
    bus_parts_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT UNIQUE NOT NULL,
    brakes_condition VARCHAR(50),
    tires_condition VARCHAR(50),
    axle_bearing_a_condition VARCHAR(50),
    axle_bearing_b_condition VARCHAR(50),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id)
);

-- Train Parts table
CREATE TABLE train_parts (
    train_parts_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT UNIQUE NOT NULL,
    catenary_condition VARCHAR(50),
    pantograph_condition VARCHAR(50),
    circuit_breaker_condition VARCHAR(50),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id)
);

-- Bus Maintenance Schedule table
CREATE TABLE bus_maintenance_schedules (
    schedule_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT UNIQUE NOT NULL,
    brakes_maintenance_km INT,
    tires_maintenance_km INT,
    axle_bearing_a_maintenance_km INT,
    axle_bearing_b_maintenance_km INT,
    brakes_next_maintenance_date DATE,
    brakes_last_maintenance_date DATE,
    tires_next_maintenance_date DATE,
    tires_last_maintenance_date DATE,
    axle_bearing_a_next_maintenance_date DATE,
    axle_bearing_a_last_maintenance_date DATE,
    axle_bearing_b_next_maintenance_date DATE,
    axle_bearing_b_last_maintenance_date DATE,
    next_service_overhaul_date DATE,
    last_service_overhaul_date DATE,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id)
);

-- Train Maintenance Schedule table
CREATE TABLE train_maintenance_schedules (
    schedule_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT UNIQUE NOT NULL,
    catenary_maintenance_km INT,
    pantograph_maintenance_km INT,
    circuit_breakers_maintenance_km INT,
    catenary_next_maintenance_date DATE,
    catenary_last_maintenance_date DATE,
    pantograph_next_maintenance_date DATE,
    pantograph_last_maintenance_date DATE,
    circuit_breakers_next_maintenance_date DATE,
    circuit_breakers_last_maintenance_date DATE,
    next_service_overhaul_date DATE,
    last_service_overhaul_date DATE,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id)
);

-- Routes table
CREATE TABLE routes (
    route_id INT AUTO_INCREMENT PRIMARY KEY,
    route_name VARCHAR(100) UNIQUE NOT NULL
);

-- Stops table
CREATE TABLE stops (
    stop_id INT AUTO_INCREMENT PRIMARY KEY,
    stop_name VARCHAR(100) NOT NULL,
    latitude DECIMAL(10,6) NOT NULL,
    longitude DECIMAL(10,6) NOT NULL
);

-- Route Stops (junction table for routes and stops)
CREATE TABLE route_stops (
    route_id INT NOT NULL,
    stop_id INT NOT NULL,
    stop_sequence INT NOT NULL,
    PRIMARY KEY (route_id, stop_id),
    FOREIGN KEY (route_id) REFERENCES routes(route_id),
    FOREIGN KEY (stop_id) REFERENCES stops(stop_id)
);

-- Vehicle GPS data table
CREATE TABLE vehicle_gps_data (
    gps_data_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT NOT NULL,
    timestamp DATETIME NOT NULL,
    latitude DECIMAL(10,6) NOT NULL,
    longitude DECIMAL(10,6) NOT NULL,
    fuel_level DECIMAL(10,2),
    vehicle_running BOOLEAN,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id)
);

-- Maintenance Alerts table
CREATE TABLE maintenance_alerts (
    alert_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT NOT NULL,
    alert_type VARCHAR(50) NOT NULL,
    alert_message TEXT,
    created_at DATETIME NOT NULL,
    resolved BOOLEAN DEFAULT FALSE,
    resolved_at DATETIME,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id)
);

-- Vehicle Route Assignment History table
CREATE TABLE route_assignment_history (
    assignment_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT NOT NULL,
    route_id INT NOT NULL,
    assigned_at DATETIME NOT NULL,
    unassigned_at DATETIME,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id),
    FOREIGN KEY (route_id) REFERENCES routes(route_id)
);