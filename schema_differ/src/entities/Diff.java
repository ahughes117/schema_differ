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
    public String explanation;

    public Diff(String type, String name, String explanation) {
        this.type = type;
        this.name = name;
        this.explanation = explanation;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getExplanation() {
        return explanation;
    }
}
