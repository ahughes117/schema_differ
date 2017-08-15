package entities;

import java.util.ArrayList;

/**
 * The Table Entity Class
 *
 * @author ahughes
 */
public class Table {

    private String name;
    private ArrayList<Column> columns;
    private ArrayList<ForeignKey> foreignKeys;

    public Table(String aName, ArrayList<Column> aColumnL, ArrayList<ForeignKey> aForeignKeyL) {
        name = aName;
        columns = aColumnL;
        foreignKeys = aForeignKeyL;
    }

    public Table(String aName) {
        name = aName;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Column> getColumns() {
        return columns;
    }

    public ArrayList<ForeignKey> getForeignKeys() {
        return foreignKeys;
    }

    public void setColumns(ArrayList<Column> aColumnL) {
        columns = aColumnL;
    }

    public void setForeignKeys(ArrayList<ForeignKey> aForeignKeyL) {
        foreignKeys = aForeignKeyL;
    }

    @Override
    public boolean equals(Object o) {
        int result;

        //casting the object
        Table tab = (Table) o;

        //comparing
        result = this.name.compareTo(tab.getName());

        //if the table names are different, return false immediately
        if (result != 0) {
            return false;
        } else {
            return true;
        }
    }

}
