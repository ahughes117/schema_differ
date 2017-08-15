package entities;

/**
 * The Foreign Key Entity Class
 *
 * @author ahughes
 */
public class ForeignKey {

    private String tableName;
    private String columnName;
    private String foreignTableName;
    private String foreignColumnName;

    public ForeignKey(String aTableName, String aColumnName, String aForeignTableName,
            String aForeignColumnName) {
        tableName = aTableName;
        columnName = aColumnName;
        foreignTableName = aForeignTableName;
        foreignColumnName = aForeignColumnName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getForeignTableName() {
        return foreignTableName;
    }

    public String getForeignColumnName() {
        return foreignColumnName;
    }

    @Override
    public boolean equals(Object o) {
        int tn, cn, ftn, fcn;

        //casting the object
        ForeignKey fk = (ForeignKey) o;

        //comparing
        tn = this.tableName.compareTo(fk.getTableName());
        cn = this.columnName.compareTo(fk.getColumnName());
        ftn = this.foreignTableName.compareTo(fk.getForeignTableName());
        fcn = this.foreignColumnName.compareTo(fk.getForeignColumnName());

        if (tn == 0 && cn == 0 && ftn == 0 && fcn == 0) {
            return true;
        } else {
            return false;
        }
    }
}
