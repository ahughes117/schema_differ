package datalayer;

import entities.Column;
import entities.Schema;
import entities.Table;
import java.sql.*;
import java.util.ArrayList;
import sql.Connector;

/**
 *
 * @author ahughes
 */
public class SchemaDL {

    private Connector c;

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
        ArrayList<Table> tables = new ArrayList();
        ArrayList<Column> columns;
        Table tab;

        DatabaseMetaData meta = c.getMetaData();
        ResultSet tableR = meta.getTables(null, null, "%", null);

        while (tableR.next()) {
            //creating the table object and assigning a name to it
            tab = new Table(tableR.getString(3));

            //creating a fresh column list object
            columns = new ArrayList();

            //fetching the column metadata 
            ResultSet columnR = c.sendQuery("SELECT * FROM " + tab.getName() + " LIMIT 0");
            ResultSetMetaData rsMeta = columnR.getMetaData();

            //iterating and populating the column ArrayList
            int columnN = rsMeta.getColumnCount();
            for (int i = 1; i <= columnN; i++) {
                columns.add(new Column(rsMeta.getColumnName(i), rsMeta.getColumnTypeName(i), Integer.toString(rsMeta.getPrecision(i)), Integer.toString(rsMeta.getScale(i))));
            }

            //finally setting the ArrayList of columns and adding the table to the list
            tab.setColumns(columns);
            tables.add(tab);
        }
        return new Schema(tables);
    }

}
