package dataaccess;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * A singleton database connection manager that provides access to a single
 * database connection. This class implements a simple connection pool pattern
 * with a single connection, reading database configuration from a properties
 * file.
 *
 * Note: This implementation is not thread-safe and is intended for
 * single-threaded applications only.
 *
 * @author roland
 */
public class DataSource {

    // Single connection instance shared across the application
    private static Connection connection = null;

    /**
     * Private constructor to prevent instantiation, following the singleton
     * pattern.
     */
    private DataSource() {
    }

    /**
     * Returns a database connection, creating a new one if necessary. This
     * method implements connection reuse to prevent memory leaks.
     *
     * Note: This method is not thread-safe and should only be used in
     * single-threaded applications.
     *
     * @return A Connection object representing the database connection
     */
    public static Connection getConnection() {
        try {
            // Create new connection only if none exists or if existing connection is closed
            if (connection == null || connection.isClosed()) {
                String[] connectionInfo = openPropsFile();
                connection = DriverManager.getConnection(connectionInfo[0], connectionInfo[1], connectionInfo[2]);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    /**
     * Reads database connection information from a properties file. Expects a
     * file named "database.properties" in the src/main/java directory with the
     * following properties: - jdbc.url: The database connection URL -
     * jdbc.username: Database username - jdbc.password: Database password
     *
     * @return String array containing connection information: [0] = connection
     * URL [1] = username [2] = password
     */
    private static String[] openPropsFile() {
        Properties props = new Properties();

        // Try-with-resources to ensure proper resource cleanup
        try (InputStream in = Files.newInputStream(Paths.get("src/main/webapp/WEB-INF/database.properties"))) {
            props.load(in);
        } catch (IOException e) {
            try (InputStream in = Files.newInputStream(Paths.get("/WEB-INF/database.properties"))) {
                props.load(in);
            } catch (IOException e2) {
                e.printStackTrace();
            }
            e.printStackTrace();
        }

        // Extract connection properties
        String connectionString = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        // Package connection info into array
        String[] info = new String[3];
        info[0] = connectionString;
        info[1] = username;
        info[2] = password;

        return info;
    }
}
