package entities;

/**
 * The Diff class, containing the information for the differences between the
 * compared schemas
 *
 * @author ahughes
 */
public class Diff {

    public String type;
    public String name;
    public int schema;

    public Diff(String type, String name, int schema) {
        this.type = type;
        this.name = name;
        this.schema = schema;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getSchema() {
        return schema;
    }

    @Override
    public String toString() {
        return type + " - " + name;
    }
}
