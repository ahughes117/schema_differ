package datalayer;

import entities.Schema;
import java.sql.*;
import java.util.ArrayList;
import sql.Connector;

/**
 *
 * @author ahughes
 */
public class SchemaDL {

    private Connector c;
    private Schema schema;

    public SchemaDL(Connector aConnector) {
        c = aConnector;
    }

    /**
     * Builds the database schema from the connector
     *
     * @return
     * @throws SQLException
     */
    public Schema buildSchema() throws SQLException {
        DatabaseMetaData meta = c.getMetaData();
        ResultSet tableR = meta.getTables(null, null, "%", null);

        while (tableR.next()) {
            System.out.println(tableR.getString(3));

            ResultSet columnR = c.sendQuery("SELECT * FROM " + tableR.getString(3) + " LIMIT 0");
            ResultSetMetaData rsMeta = columnR.getMetaData();
            int columnN = rsMeta.getColumnCount();
            for (int i = 1; i <= columnN; i++) {
                System.out.println("  " + rsMeta.getColumnName(i) + " - " + rsMeta.getColumnTypeName(i) + " " + rsMeta.getPrecision(i) + " " + rsMeta.getScale(i));
            }
        }

        return schema;
    }

    public ArrayList<String> getTables() throws SQLException {
        ArrayList<String> tables = new ArrayList();

        DatabaseMetaData meta = c.getMetaData();
        ResultSet tableR = meta.getTables(null, null, "%", null);
        while (tableR.next()) {
            tables.add(tableR.getString(3));
        }

        return tables;
    }
}
