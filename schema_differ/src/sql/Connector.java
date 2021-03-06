package sql;

/**
 * The SQL Connector Wrapper Class. Heavily Optimised (and probably tied) to
 * MySQL As JDBC supports all databases, maybe this will change in the future
 *
 * @author Alex Hughes
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {

    public static boolean AUTOCOMMIT = true;
    public static boolean LOGGER;
    public static boolean QUERY;
    protected Connection connection;
    private Credentials credentials;
    private static final String DATABASE_USER = "user";
    private static final String DATABASE_PASSWORD = "password";
    private static final String MYSQL_AUTO_RECONNECT = "autoReconnect";
    private static final String MYSQL_MAX_RECONNECTS = "maxReconnects";

    public Connector(Credentials cre) throws SQLException, ClassNotFoundException {
        credentials = cre;
        reConnect();
    }

    public void reConnect() throws SQLException, ClassNotFoundException {

        if (connection != null) {
            connection.close();
        }

        Class.forName("com.mysql.jdbc.Driver");	//in order to manipulate data on the mySQL server

        java.util.Properties connProperties = new java.util.Properties();
        connProperties.put(DATABASE_USER, credentials.getUser());
        connProperties.put(DATABASE_PASSWORD, credentials.getPass());
        connProperties.put(MYSQL_AUTO_RECONNECT, "true");
        connProperties.put(MYSQL_MAX_RECONNECTS, "2");
        connProperties.put("characterEncoding", "utf8");

        String conString = credentials.getUri();

        connection = DriverManager.getConnection(conString, connProperties);

        //hardcoding the autocommit...
        connection.setAutoCommit(AUTOCOMMIT);
        printInfo();    //used to print info of the connection
    }

    public ResultSet sendQuery(String aQuery) throws SQLException {
        ResultSet rs = null;
        Statement stmt;

        if (connection.isValid(1)) {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(aQuery);
        } else {
            try {
                reConnect();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = connection.createStatement();
            rs = stmt.executeQuery(aQuery);
        }
        if (Connector.QUERY) {
            System.out.println(aQuery);
        }
        return rs;
    }

    public PreparedStatement prepareStatement(String aQuery) throws SQLException {
        PreparedStatement ps;

        if (connection.isValid(1)) {
            ps = connection.prepareStatement(aQuery, Statement.RETURN_GENERATED_KEYS);
        } else {
            try {
                reConnect();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
            }
            ps = connection.prepareStatement(aQuery, Statement.RETURN_GENERATED_KEYS);
        }

        return ps;
    }

    public ResultSet sendUpdate(String aQuery) throws SQLException {
        Statement stmt;

        if (connection.isValid(1)) {
            stmt = connection.createStatement();
        } else {
            try {
                reConnect();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = connection.createStatement();
        }
        stmt.executeUpdate(aQuery, Statement.RETURN_GENERATED_KEYS);

        if (Connector.QUERY) {
            System.out.println(aQuery);
        }
        return stmt.getGeneratedKeys();
    }

    public void commit() throws SQLException {
        connection.commit();
        if (Connector.QUERY) {
            System.out.println("COMMIT");
        }
    }

    public void rollback() {
        try {
            connection.rollback();
            if (Connector.QUERY) {
                System.out.println("ROLLBACK");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSchema(String aSchema) throws SQLException {
        connection.setSchema(aSchema);
    }

    /**
     * Returns the database's metadata
     *
     * @return
     * @throws SQLException
     */
    public DatabaseMetaData getMetaData() throws SQLException {
        return connection.getMetaData();
    }

    public String getCatalog() throws SQLException {
        return connection.getCatalog();
    }

    public String getSchema() throws SQLException {
        return connection.getSchema();
    }

    private void printInfo() {
        System.out.println("Database Management...");
        System.out.println("Succesfully connected to: " + credentials.getUri());
        if (AUTOCOMMIT) {
            System.out.println("AUTOCOMMIT IS ON");
        } else {
            System.out.println("AUTOCOMMIT IS OFF");
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Credentials getCredentials() {
        return credentials;
    }
}
