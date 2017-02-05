public class Planet {

    /** Current x position of Planet */
    public double xxPos;
    /** Current y position of Planet */
    public double yyPos;
    /** Current velocity in the x direction */
    public double xxVel;
    /** Current velocity in the y direction */
    public double yyVel;
    /** The mass of Planet */
    public double mass;
    /** The name of the image that depicts the Planet */
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    /** Retuan a copy of Planet p*/
    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /** Return the distance between this and other certain Planet.*/
    public double calcDistance(Planet other) {
        double dx = other.xxPos - this.xxPos;
        double dy = other.yyPos - this.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    } 

    private double getCos(Planet other) {
        double distance = calcDistance(other);
        double dx = other.xxPos - this.xxPos;
        return dx / distance;
    }

    private double getSin(Planet other) {
        double distance = calcDistance(other);
        double dy = other.yyPos - this.yyPos;
        return dy / distance;
    }

    /** Return gravitational force between two plants by implementing Newton's law of universal gravitation */
    public double calcForceExertedBy(Planet other) {
        final double G = 6.67e-11;
        double distance = calcDistance(other);
        double force = (G * this.mass * other.mass) / (distance * distance);
        return force;
    }

    /** Return the force in X direction exerted by other Planet. */
    public double calcForceExertedByX(Planet other) {
        double cos = getCos(other);
        double force = calcForceExertedBy(other);
        return force * cos;
    }

    /** Return the force in Y position exerted by other Planet. */
    public double calcForceExertedByY(Planet other) {
        double sin = getSin(other);
        double force = calcForceExertedBy(other);
        return force * sin;
    }

    /** Return the net force on this in X direction exerted by all other planets.*/
    public double calcNetForceExertedByX(Planet[] others) {
        double netForceX = 0;
        for(int i = 0; i < others.length; i++) {
            if (this.equals(others[i])) {
                continue;
            }
            double xForce = calcForceExertedByX(others[i]);
            netForceX += xForce;
        }
        return netForceX;
    }

    /** Return the net force on this in Y direction exerted by all other planets.*/
    public double calcNetForceExertedByY(Planet[] others) {
        double netForceY = 0;
        for(int i = 0; i < others.length; i++) {
            if (this.equals(others[i])) {
                continue;
            }
            double yForce = calcForceExertedByY(others[i]);
            netForceY += yForce;
        }
        return netForceY;
    }

    public void update(double dt, double fX, double fY) {
        double accX = fX / this.mass;
        double accY = fY / this.mass;

        this.xxVel = this.xxVel + dt * accX;
        this.yyVel = this.yyVel + dt * accY;

        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

}
