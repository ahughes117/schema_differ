package datalayer;

import entities.Column;
import entities.ForeignKey;
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
        ArrayList<ForeignKey> foreignKeys;
        Table tab;

        DatabaseMetaData meta = c.getMetaData();
        ResultSet tableR = meta.getTables(null, null, "%", null);

        while (tableR.next()) {
            //creating the table object and assigning a name to it
            tab = new Table(tableR.getString(3));

            //creating a fresh foreign key list object
            foreignKeys = new ArrayList();

            ResultSet keyR = meta.getExportedKeys(c.getCatalog(), null, tableR.getString(3));
            while (keyR.next()) {
                foreignKeys.add(new ForeignKey(keyR.getString("fktable_name"), keyR.getString("fkcolumn_name"),
                        keyR.getString("pktable_name"), keyR.getString("pkcolumn_name")));
            }

            tab.setForeignKeys(foreignKeys);

            //creating a fresh column list object
            columns = new ArrayList();

            //fetching the column metadata 
            ResultSet columnR = c.sendQuery("SELECT * FROM `" + tab.getName() + "` LIMIT 0");
            ResultSetMetaData rsMeta = columnR.getMetaData();

            //iterating and populating the column ArrayList
            int columnN = rsMeta.getColumnCount();
            for (int i = 1; i <= columnN; i++) {
                columns.add(new Column(rsMeta.getColumnName(i), rsMeta.getColumnTypeName(i),
                        Integer.toString(rsMeta.getPrecision(i)), Integer.toString(rsMeta.getScale(i))));
            }

            //finally setting the ArrayList of columns and adding the table to the list
            tab.setColumns(columns);
            tables.add(tab);
        }
        return new Schema(tables);
    }

}
