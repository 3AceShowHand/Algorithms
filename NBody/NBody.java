public class NBody {

    public static void main(String[] args) {
        Double T = Double.parseDouble(args[0]);
        Double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        Planet[] plts = readPlanets(filename);
        double radius = readRadius(filename);
        String imageToDraw = "./images/starfield.jpg";

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, imageToDraw);
        
        for(int i = 0; i < plts.length; i++) {
            plts[i].imgFileName = "./images/".concat(plts[i].imgFileName);
            plts[i].draw();
        }

        StdDraw.show();
    }

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

}

