package entities;

/**
 * The Column Entity Class
 *
 * @author ahughes
 */
public class Column {

    private String name;
    private String type;
    private String precision;
    private String scale;

    public Column(String aName, String aType, String aPrecision, String aScale) {
        name = aName;
        type = aType;
        precision = aPrecision;
        scale = aScale;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPrecision() {
        return precision;
    }

    public String getScale() {
        return scale;
    }

    @Override
    public boolean equals(Object o) {
        int n, t, p, s;

        //casting the object
        Column col = (Column) o;

        //comparing
        n = this.name.compareTo(col.getName());
        t = this.type.compareTo(col.getType());
        p = this.precision.compareTo(col.getPrecision());
        s = this.scale.compareTo(col.getScale());

        //returning
        if (n == 0 && t == 0 && p == 0 && s == 0) {
            return true;
        } else {
            return false;
        }
    }
}
