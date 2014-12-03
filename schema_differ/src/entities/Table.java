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

    public Table(String aName, ArrayList<Column> aColumnT) {
        name = aName;
        columns = aColumnT;
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

    public void setColumns(ArrayList<Column> aColumnL) {
        columns = aColumnL;
    }

    @Override
    public boolean equals(Object o) {
        int name;

        //casting the object
        Table tab = (Table) o;

        //comparing
        name = this.name.compareTo(tab.getName());

        //if the table names are different, return false immediately
        if (name != 0) {
            return false;
        } else {
            return true;
        }
    }

}
