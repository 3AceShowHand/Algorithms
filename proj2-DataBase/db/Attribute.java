package db;

/**
 * Created by Christopher on 2017/4/3.
 */
public class Attribute {

    //
    private String label;
    private String type;

    public Attribute(String lab, String ty) {
        this.label = lab;
        this.type = ty;
    }

    public String getLabel() {
        return this.label;
    }

    public String getType() {
        return this.type;
    }

}
