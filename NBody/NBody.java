public class NBody {
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int size = in.readInt();
        double radius = in.readDouble();
        // for(int i = 0; i < 2; i ++) {
        //     radius = in.readDouble();
        // }
        return radius;
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);

        int size = in.readInt();
        double radius = in.readDouble();

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
    public static void main(String[] args) {
        int T = args[0];
        int dt = args[1];
        String filename = args[2];

        Planets[] plts = readPlanets(filename);
        double radius = readRadius(filename);
    }
}
