# Public Transit Fleet Management System (PTFMS)

## Overview
The Public Transit Fleet Management System (PTFMS) is a web-based application designed for public transit agencies to monitor, track, and optimize operations of buses, electric light rail, and diesel-electric trains. The system integrates real-time GPS tracking, fuel/energy monitoring, predictive maintenance alerts, and route optimization to improve transit efficiency and reliability.

## Technology Stack
- Java 21
- Java Servlets
- MySQL 8.0.40
- Apache Tomcat 9.0.90 (or later)
- Maven (NetBeans project)

## Architecture
The project implements a 3-tier architecture:
- Presentation Layer
- Business Layer
- Data Layer

## Design Patterns
The following GoF Design Patterns are implemented:
- DAO (Data Access Object)
- Builder
- Plus four additional patterns selected from:
  - Strategy
  - Simple Factory
  - Adapter
  - Observer
  - Command

## Key Features

### User Registration & Authentication
- Registration for Transit Managers and Operators
- Login/logout functionality
- Role-based access control

### Vehicle Management
- Registration of different vehicle types:
  - Diesel Bus
  - Electric Light Rail
  - Diesel-Electric Train
- Tracking of vehicle details including vehicle number, fuel/energy consumption rate, passenger capacity, and route assignments

### GPS Tracking
- Real-time location monitoring
- Arrival and departure time reporting
- Out-of-service logging for operators

### Energy/Fuel Consumption Monitoring
- Efficiency tracking for different vehicle types
- Alerts for excessive consumption

### Predictive Maintenance
- Monitoring of component wear and usage hours
- Engine diagnostics
- Maintenance scheduling

### Reporting & Analytics
- Maintenance dashboards
- Operator performance metrics
- Cost reporting

## Installation Instructions

1. Clone the repository
2. Import the project into NetBeans as a Maven project
3. Set up a MySQL database with credentials (user: cst8288, password: cst8288)
4. Run the SQL scripts in the `database` directory to create the schema and populate it with sample data
5. Configure Apache Tomcat 9.0.90 or later
6. Build and deploy the application

## Database Configuration
The database connection properties are stored in the `.properties` file with the following format:
```
jdbc.url=jdbc:mysql://localhost:3306/ptfms
jdbc.username=cst8288
jdbc.password=cst8288
```

## Project Structure
- `/src/main/java` - Java source files
- `/src/main/webapp` - Web resources
- `/src/test/java` - JUnit tests
- `/database` - SQL scripts for database setup
- `/docs` - Documentation including UML diagrams and design documents

## Contributors
- David Santos – 041081890
- Jawad Hamed - 041164911
- Roland Marchand - 041163849
- Sebastien Levesque - 040965642

## License
Copyright (C) 2025 by Roland Marchand <marc0424@algonquinlive.com> <roland.marchand@protonmail.com>, D. Santos, Sebastien Levesque, Jawad Hamed
