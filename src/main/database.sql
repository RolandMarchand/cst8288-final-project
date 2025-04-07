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
    PRIMARY KEY (route_id, stop_id, stop_sequence),
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

-- Inserting data into vehicle_types table
INSERT INTO vehicle_types (type_id, description) VALUES
('BUS_STANDARD', 'Standard city bus'),
('BUS_ARTICULATED', 'Articulated (bendable) city bus'),
('BUS_MINIBUS', 'Smaller capacity city bus'),
('TRAIN_LOCAL', 'Local commuter train'),
('TRAIN_EXPRESS', 'Express commuter train');

-- Inserting data into fuel_energy_types table
INSERT INTO fuel_energy_types (energy_id, description) VALUES
('DIESEL', 'Standard diesel fuel'),
('CNG', 'Compressed Natural Gas'),
('ELECTRIC', 'Electric powered'),
('HYBRID', 'Diesel-electric hybrid');

-- Inserting data into routes table
INSERT INTO routes (route_name) VALUES
('Downtown Loop'),
('Airport Express'),
('University Route'),
('East-West Connector'),
('North Shore Line'),
('South Hills Express'),
('Central Station Loop'),
('Harbor Line');

-- Inserting data into stops table
INSERT INTO stops (stop_name, latitude, longitude) VALUES
('Central Station', 40.441606, -79.999084),
('Airport Terminal', 40.496269, -80.241983),
('University Campus', 40.444269, -79.943910),
('Downtown Square', 40.440624, -79.995888),
('East End', 40.459782, -79.925044),
('Riverside', 40.435459, -80.023401),
('Tech District', 40.456589, -79.916748),
('South Hills Junction', 40.421131, -79.994125),
('North Shore Station', 40.446785, -80.005862),
('West End Terminal', 40.439590, -80.034149),
('Harbor View', 40.436871, -80.015604),
('Medical Center', 40.441977, -79.961232);

-- Inserting data into route_stops table
INSERT INTO route_stops (route_id, stop_id, stop_sequence) VALUES
-- Downtown Loop (Route 1)
(1, 1, 1),  -- Central Station
(1, 4, 2),  -- Downtown Square
(1, 7, 3),  -- Tech District
(1, 4, 4),  -- Downtown Square (loop back)
(1, 1, 5),  -- Central Station (end)

-- Airport Express (Route 2)
(2, 1, 1),  -- Central Station
(2, 10, 2), -- West End Terminal
(2, 2, 3),  -- Airport Terminal

-- University Route (Route 3)
(3, 1, 1),  -- Central Station
(3, 4, 2),  -- Downtown Square
(3, 12, 3), -- Medical Center
(3, 3, 4),  -- University Campus

-- East-West Connector (Route 4)
(4, 10, 1), -- West End Terminal
(4, 6, 2),  -- Riverside
(4, 1, 3),  -- Central Station
(4, 5, 4),  -- East End

-- North Shore Line (Route 5)
(5, 1, 1),  -- Central Station
(5, 9, 2),  -- North Shore Station
(5, 11, 3), -- Harbor View

-- South Hills Express (Route 6)
(6, 1, 1),  -- Central Station
(6, 4, 2),  -- Downtown Square
(6, 8, 3),  -- South Hills Junction

-- Central Station Loop (Route 7)
(7, 1, 1),  -- Central Station
(7, 4, 2),  -- Downtown Square
(7, 12, 3), -- Medical Center
(7, 7, 4),  -- Tech District
(7, 5, 5),  -- East End
(7, 1, 6),  -- Central Station (end)

-- Harbor Line (Route 8)
(8, 1, 1),  -- Central Station
(8, 9, 2),  -- North Shore Station
(8, 11, 3), -- Harbor View
(8, 6, 4);  -- Riverside

-- Inserting data into vehicles table
INSERT INTO vehicles (registration_number, vehicle_type_id, fuel_energy_type_id, consumption_rate, max_passengers, current_route_id) VALUES
-- Buses
('BUS-1001', 'BUS_STANDARD', 'DIESEL', 28.50, 85, 1),
('BUS-1002', 'BUS_STANDARD', 'DIESEL', 29.10, 85, 3),
('BUS-1003', 'BUS_ARTICULATED', 'DIESEL', 38.20, 120, 4),
('BUS-1004', 'BUS_MINIBUS', 'CNG', 18.50, 35, 1),
('BUS-1005', 'BUS_STANDARD', 'CNG', 26.70, 85, 6),
('BUS-1006', 'BUS_STANDARD', 'HYBRID', 22.30, 85, 3),
('BUS-1007', 'BUS_ARTICULATED', 'HYBRID', 30.10, 120, 7),
('BUS-1008', 'BUS_MINIBUS', 'ELECTRIC', 15.20, 35, NULL),
('BUS-1009', 'BUS_STANDARD', 'DIESEL', 28.90, 85, 6),
('BUS-1010', 'BUS_STANDARD', 'CNG', 27.10, 85, NULL),

-- Trains
('TRAIN-2001', 'TRAIN_LOCAL', 'ELECTRIC', 150.00, 500, 5),
('TRAIN-2002', 'TRAIN_EXPRESS', 'ELECTRIC', 180.00, 450, 2),
('TRAIN-2003', 'TRAIN_LOCAL', 'ELECTRIC', 155.00, 500, 8),
('TRAIN-2004', 'TRAIN_EXPRESS', 'ELECTRIC', 175.00, 450, NULL),
('TRAIN-2005', 'TRAIN_LOCAL', 'ELECTRIC', 152.00, 500, 5);

-- Inserting data into bus_parts table
INSERT INTO bus_parts (vehicle_id, brakes_condition, tires_condition, axle_bearing_a_condition, axle_bearing_b_condition) VALUES
(1, 'Good', 'Fair', 'Good', 'Good'),
(2, 'Good', 'Good', 'Good', 'Fair'),
(3, 'Fair', 'Good', 'Good', 'Good'),
(4, 'Good', 'Good', 'Good', 'Good'),
(5, 'Good', 'Fair', 'Fair', 'Good'),
(6, 'Fair', 'Good', 'Good', 'Good'),
(7, 'Good', 'Good', 'Good', 'Fair'),
(8, 'Good', 'Good', 'Good', 'Good'),
(9, 'Fair', 'Fair', 'Good', 'Good'),
(10, 'Good', 'Good', 'Good', 'Good');

-- Inserting data into train_parts table
INSERT INTO train_parts (vehicle_id, catenary_condition, pantograph_condition, circuit_breaker_condition) VALUES
(11, 'Good', 'Good', 'Good'),
(12, 'Good', 'Fair', 'Good'),
(13, 'Fair', 'Good', 'Good'),
(14, 'Good', 'Good', 'Fair'),
(15, 'Good', 'Good', 'Good');

-- Inserting data into bus_maintenance_schedules table
INSERT INTO bus_maintenance_schedules (
    vehicle_id, 
    brakes_maintenance_km, 
    tires_maintenance_km, 
    axle_bearing_a_maintenance_km, 
    axle_bearing_b_maintenance_km, 
    brakes_next_maintenance_date, 
    brakes_last_maintenance_date, 
    tires_next_maintenance_date, 
    tires_last_maintenance_date, 
    axle_bearing_a_next_maintenance_date, 
    axle_bearing_a_last_maintenance_date, 
    axle_bearing_b_next_maintenance_date, 
    axle_bearing_b_last_maintenance_date, 
    next_service_overhaul_date, 
    last_service_overhaul_date
) VALUES
(1, 25000, 40000, 100000, 100000, '2025-06-15', '2024-12-15', '2025-07-10', '2024-10-10', '2025-09-30', '2024-03-30', '2025-09-30', '2024-03-30', '2025-10-15', '2024-04-15'),
(2, 25000, 40000, 100000, 100000, '2025-07-20', '2025-01-20', '2025-05-12', '2024-08-12', '2025-11-05', '2024-05-05', '2025-11-05', '2024-05-05', '2025-11-20', '2024-05-20'),
(3, 25000, 40000, 100000, 100000, '2025-05-10', '2024-11-10', '2025-08-22', '2024-11-22', '2025-10-15', '2024-04-15', '2025-10-15', '2024-04-15', '2025-09-10', '2024-03-10'),
(4, 25000, 40000, 100000, 100000, '2025-08-05', '2025-02-05', '2025-09-18', '2024-12-18', '2026-01-25', '2024-07-25', '2026-01-25', '2024-07-25', '2025-12-05', '2024-06-05'),
(5, 25000, 40000, 100000, 100000, '2025-06-25', '2024-12-25', '2025-04-30', '2024-07-30', '2025-08-12', '2024-02-12', '2025-08-12', '2024-02-12', '2025-08-25', '2024-02-25'),
(6, 25000, 40000, 100000, 100000, '2025-05-18', '2024-11-18', '2025-06-22', '2024-09-22', '2025-09-08', '2024-03-08', '2025-09-08', '2024-03-08', '2025-07-18', '2024-01-18'),
(7, 25000, 40000, 100000, 100000, '2025-07-30', '2025-01-30', '2025-08-15', '2024-11-15', '2025-12-10', '2024-06-10', '2025-12-10', '2024-06-10', '2025-11-30', '2024-05-30'),
(8, 25000, 40000, 100000, 100000, '2025-09-12', '2025-03-12', '2025-10-05', '2025-01-05', '2026-02-18', '2024-08-18', '2026-02-18', '2024-08-18', '2026-01-12', '2024-07-12'),
(9, 25000, 40000, 100000, 100000, '2025-06-08', '2024-12-08', '2025-05-14', '2024-08-14', '2025-08-22', '2024-02-22', '2025-08-22', '2024-02-22', '2025-09-08', '2024-03-08'),
(10, 25000, 40000, 100000, 100000, '2025-08-25', '2025-02-25', '2025-09-30', '2024-12-30', '2026-01-15', '2024-07-15', '2026-01-15', '2024-07-15', '2025-12-25', '2024-06-25');

-- Inserting data into train_maintenance_schedules table
INSERT INTO train_maintenance_schedules (
    vehicle_id, 
    catenary_maintenance_km, 
    pantograph_maintenance_km, 
    circuit_breakers_maintenance_km, 
    catenary_next_maintenance_date, 
    catenary_last_maintenance_date, 
    pantograph_next_maintenance_date, 
    pantograph_last_maintenance_date, 
    circuit_breakers_next_maintenance_date, 
    circuit_breakers_last_maintenance_date, 
    next_service_overhaul_date, 
    last_service_overhaul_date
) VALUES
(11, 30000, 20000, 25000, '2025-09-15', '2025-03-15', '2025-07-20', '2025-01-20', '2025-08-10', '2025-02-10', '2025-11-15', '2024-11-15'),
(12, 30000, 20000, 25000, '2025-10-22', '2025-04-22', '2025-06-18', '2024-12-18', '2025-09-05', '2025-03-05', '2025-12-22', '2024-12-22'),
(13, 30000, 20000, 25000, '2025-08-05', '2025-02-05', '2025-08-12', '2025-02-12', '2025-07-25', '2025-01-25', '2025-10-05', '2024-10-05'),
(14, 30000, 20000, 25000, '2025-11-18', '2025-05-18', '2025-09-30', '2025-03-30', '2025-10-15', '2025-04-15', '2026-01-18', '2025-01-18'),
(15, 30000, 20000, 25000, '2025-09-08', '2025-03-08', '2025-07-12', '2025-01-12', '2025-08-22', '2025-02-22', '2025-11-08', '2024-11-08');

-- Inserting data into vehicle_gps_data table
INSERT INTO vehicle_gps_data (vehicle_id, timestamp, latitude, longitude, fuel_level, vehicle_running) VALUES
-- BUS-1001 (Route 1: Downtown Loop)
(1, '2025-04-06 08:15:00', 40.441606, -79.999084, 85.5, TRUE),  -- Central Station
(1, '2025-04-06 08:25:00', 40.440624, -79.995888, 84.8, TRUE),  -- Downtown Square
(1, '2025-04-06 08:40:00', 40.456589, -79.916748, 83.2, TRUE),  -- Tech District
(1, '2025-04-06 08:55:00', 40.440624, -79.995888, 82.1, TRUE),  -- Downtown Square
(1, '2025-04-06 09:10:00', 40.441606, -79.999084, 81.0, TRUE),  -- Central Station

-- BUS-1002 (Route 3: University Route)
(2, '2025-04-06 08:10:00', 40.441606, -79.999084, 76.2, TRUE),  -- Central Station
(2, '2025-04-06 08:22:00', 40.440624, -79.995888, 75.3, TRUE),  -- Downtown Square
(2, '2025-04-06 08:38:00', 40.441977, -79.961232, 73.8, TRUE),  -- Medical Center
(2, '2025-04-06 08:50:00', 40.444269, -79.943910, 72.5, TRUE),  -- University Campus

-- TRAIN-2001 (Route 5: North Shore Line)
(11, '2025-04-06 08:05:00', 40.441606, -79.999084, 92.0, TRUE),  -- Central Station
(11, '2025-04-06 08:18:00', 40.446785, -80.005862, 91.2, TRUE),  -- North Shore Station
(11, '2025-04-06 08:30:00', 40.436871, -80.015604, 90.5, TRUE),  -- Harbor View

-- BUS-1003 (Route 4: East-West Connector)
(3, '2025-04-06 08:20:00', 40.439590, -80.034149, 68.7, TRUE),  -- West End Terminal
(3, '2025-04-06 08:35:00', 40.435459, -80.023401, 67.1, TRUE),  -- Riverside
(3, '2025-04-06 08:55:00', 40.441606, -79.999084, 65.3, TRUE),  -- Central Station
(3, '2025-04-06 09:15:00', 40.459782, -79.925044, 63.8, TRUE),  -- East End

-- BUS-1008 (Not currently on a route, in depot)
(8, '2025-04-06 08:00:00', 40.441606, -79.999084, 95.0, FALSE),  -- Central Station (depot)
(8, '2025-04-06 09:00:00', 40.441606, -79.999084, 95.0, FALSE),  -- Central Station (depot)

-- TRAIN-2002 (Route 2: Airport Express)
(12, '2025-04-06 08:10:00', 40.441606, -79.999084, 88.5, TRUE),  -- Central Station
(12, '2025-04-06 08:30:00', 40.439590, -80.034149, 87.2, TRUE),  -- West End Terminal
(12, '2025-04-06 08:50:00', 40.496269, -80.241983, 85.6, TRUE);  -- Airport Terminal

-- Inserting data into maintenance_alerts table
INSERT INTO maintenance_alerts (vehicle_id, alert_type, alert_message, created_at, resolved, resolved_at) VALUES
(5, 'SCHEDULED', 'Tires need replacement based on condition assessment', '2025-04-01 10:15:00', FALSE, NULL),
(3, 'EMERGENCY', 'Brakes showing unusual wear pattern', '2025-04-03 14:22:00', TRUE, '2025-04-04 09:45:00'),
(12, 'SCHEDULED', 'Pantograph maintenance required before next maintenance date', '2025-03-28 09:30:00', FALSE, NULL),
(9, 'WARNING', 'Tire pressure consistently below recommended levels', '2025-04-05 07:45:00', FALSE, NULL),
(13, 'EMERGENCY', 'Circuit breaker tripped during operation', '2025-04-02 16:10:00', TRUE, '2025-04-02 20:30:00'),
(7, 'WARNING', 'Axle bearing noise detected', '2025-04-04 11:35:00', FALSE, NULL),
(1, 'SCHEDULED', 'Routine 6-month inspection due', '2025-03-25 08:00:00', TRUE, '2025-04-01 14:20:00');

-- Inserting data into route_assignment_history table
INSERT INTO route_assignment_history (vehicle_id, route_id, assigned_at, unassigned_at) VALUES
(1, 1, '2025-01-15 06:00:00', NULL),  -- BUS-1001 current route
(2, 3, '2025-02-01 05:30:00', NULL),  -- BUS-1002 current route
(3, 4, '2025-01-10 06:00:00', NULL),  -- BUS-1003 current route
(4, 1, '2025-03-01 06:00:00', NULL),  -- BUS-1004 current route
(5, 6, '2025-02-15 05:30:00', NULL),  -- BUS-1005 current route
(6, 3, '2025-03-15 06:00:00', NULL),  -- BUS-1006 current route
(7, 7, '2025-02-20 05:30:00', NULL),  -- BUS-1007 current route
(8, 6, '2025-01-05 06:00:00', '2025-04-05 22:00:00'),  -- BUS-1008 previous route (currently in maintenance)
(9, 6, '2025-03-10 06:00:00', NULL),  -- BUS-1009 current route
(10, 7, '2025-01-20 05:30:00', '2025-04-04 22:00:00'),  -- BUS-1010 previous route (currently in maintenance)
(11, 5, '2025-02-10 05:00:00', NULL),  -- TRAIN-2001 current route
(12, 2, '2025-01-25 05:00:00', NULL),  -- TRAIN-2002 current route
(13, 8, '2025-03-05 05:00:00', NULL),  -- TRAIN-2003 current route
(14, 5, '2025-02-05 05:00:00', '2025-04-03 23:00:00'),  -- TRAIN-2004 previous route (currently in maintenance)
(15, 5, '2025-01-30 05:00:00', NULL),  -- TRAIN-2005 current route

-- Previous route assignments history
(1, 6, '2024-07-10 06:00:00', '2025-01-15 05:30:00'),
(3, 1, '2024-08-15 06:00:00', '2025-01-10 05:30:00'),
(5, 3, '2024-09-01 05:30:00', '2025-02-15 05:00:00'),
(7, 4, '2024-10-05 06:00:00', '2025-02-20 05:00:00'),
(9, 1, '2024-09-15 06:00:00', '2025-03-10 05:30:00'),
(11, 8, '2024-08-20 05:00:00', '2025-02-10 04:30:00'),
(13, 2, '2024-10-15 05:00:00', '2025-03-05 04:30:00');
