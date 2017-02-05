public class NBody {
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        double radius = 0;
        for(int i = 0; i < 2; i ++) {
            radius = in.readDouble();
        }
        return radius;
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        /**Filter out first two lines. */
        for(int i = 0; i < 2; i++) {
            double radius = in.readDouble();
        }

        Planet[] res = new Planet[5];
        for(int i = 0; i < 5; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double mass = in.readDouble();
            String picName = in.readString();
            res[i] = new Planet(xP, yP, xV, yV, mass, picName);
        }
        return res;
    }
}
