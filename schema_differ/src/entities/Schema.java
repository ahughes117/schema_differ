package entities;

import java.util.ArrayList;

/**
 * The Schema Entity Class
 *
 * @author ahughes
 */
public class Schema {

    private ArrayList<Table> tables;

    public Schema(ArrayList<Table> aTableL) {
        tables = aTableL;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    @Override
    public boolean equals(Object o) {
        Schema sche = (Schema) o;

        if (this.tables.containsAll(sche.getTables()) && sche.getTables().containsAll(this.tables)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String output = "";

        for (Table t : tables) {
            //first printing the table name
            output += t.getName() + "\n";

            //then proceeding with the columns
            for (Column c : t.getColumns()) {
                output += "    " + c.getName() + " - " + c.getType() + "\n";
            }
        }

        return output;
    }

}
