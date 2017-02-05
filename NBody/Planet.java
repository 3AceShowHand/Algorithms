public class Planet {

    /** Current x position of planet */
    public double xxPos;
    /** Current y position of planet */
    public double yyPos;
    /** Current velocity in the x direction */
    public double xxVel;
    /** Current velocity in the y direction */
    public double yyVel;
    /** The mass of planet */
    public double mass;
    /** The name of the image that depicts the planet */
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }


}
