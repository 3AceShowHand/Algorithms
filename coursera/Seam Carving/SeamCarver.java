import edu.princeton.cs.algs4.Picture;
import java.util.Arrays;
import java.awt.Color;


public class SeamCarver {

    private Picture pic;
    private final double[][] distribution;
    private Picture rotatedPic;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException("Given a null picture object");
        }
        pic = new Picture(picture);
        distribution = buildDistribution();

        rotatedPic = new Picture(pic.height(), pic.width());
        for (int row = 0; row < pic.height(); row++) {
            for (int col = 0; col < pic.width(); col++) {
                Color current = pic.get(col, row);
                rotatedPic.set(row, col, current);
            }
        }
    }

    //current picture
    public Picture picture() {
        return pic;
    }

    // width of current picture
    public int width() {
        return pic.width();
    }

    // height of current picture
    public int height() {
        return pic.height();
    }

    private boolean onBoard(int x, int y) {
        return (x == 0 || x == pic.width() - 1 || y == 0 || y == pic.height() - 1);
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        if (x < 0 || x >= width()) {
            throw new IllegalArgumentException("Given x is not in range");
        }
        if (y < 0 || y >= height()) {
            throw new IllegalArgumentException("Given y is not in range");
        }

        if (onBoard(x, y)) {
            return 1000;
        } else {
            Color left = pic.get(x - 1, y);
            Color right = pic.get(x + 1, y);
            Color upper = pic.get(x, y - 1);
            Color down = pic.get(x, y + 1);

            int rx = right.getRed() - left.getRed();
            int gx = right.getGreen() - left.getGreen();
            int bx = right.getBlue() - left.getBlue();
            int dx = rx * rx + gx * gx + bx * bx;

            int ry = upper.getRed() - down.getRed();
            int gy = upper.getGreen() - down.getGreen();
            int by = upper.getBlue() - down.getBlue();
            int dy = ry * ry + gy * gy + by * by;

            return Math.sqrt(dx + dy);
        }
    }

    private boolean checkRange(int x, double[][] dist) {
        int width = dist[0].length;

        return x >= 0 && x < width;
    }

    private double[][] buildDistribution() {
        double[][] distribution = new double[height()][width()];
        for (int row = 0; row < distribution.length; row++) {
            for (int col = 0; col < distribution[0].length; col++) {
                distribution[row][col] = energy(col, row);
            }
        }
        return distribution;
    }

    private double[][] rotateDistribution() {
        int width = distribution[0].length;
        int height = distribution.length;

        double[][] res = new double[width][height];
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {
                res[row][col] = energy(row, col);
            }
        }
        return res;
    }

    private double singleFindSeam(int x, double[][] dist, int[] idx) {
        double res = dist[0][x];
        idx[0] = x;
        for (int row = 1; row < dist.length; row++){
            int[] nextXs = new int[]{x-1, x, x+1};
            double min = 1000;
            int nextX = x - 1;

            for (int col: nextXs) {
                if (checkRange(col, dist)) {
                    if (dist[row][col] < min) {
                        min = dist[row][col];
                        nextX = col;
                    }
                }
            }
            res += min;
            idx[row] = nextX;
            x = nextX;
        }
        return res;
    }

    private int[] findVerticalSeamAux(double[][] distribution) {
        int[] swap = new int[distribution.length];
        double minTotal = singleFindSeam(0, distribution, swap);
        int[] res = Arrays.copyOf(swap, swap.length);
        for (int col = 1; col < distribution[0].length; col++) {
            double totalEnergy = singleFindSeam(col, distribution, swap);
            if (totalEnergy < minTotal) {
                minTotal = totalEnergy;
                res = Arrays.copyOf(swap, swap.length);
            }
        }
        return res;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        return findVerticalSeamAux(distribution);
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        double[][] rotated = rotateDistribution();
        return findVerticalSeamAux(rotated);
    }

    private void shiftSingleLine(int row, int col) {
        Color next = null;
        for (int i = col; col < width(); col++) {
            if (col == width()-1) {
                next = Color.white;
            } else {
                next = pic.get(col+1, row);
            }
            pic.set(col, row, next);
        }
    }

    private void shiftPicture(int[] seam) {
        for (int row = 0; row < seam.length; row++) {
            int col = seam[row];
            shiftSingleLine(row, col);
        }

    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        if (pic.width() <= 1) {
            throw new IllegalArgumentException("The width of given picture is less than or equal to 1");
        }
        if (seam == null) {
            throw new IllegalArgumentException("Given a null seam object");
        }
        if (seam.length != pic.height()) {
            throw new IllegalArgumentException("The height of the seam not match the width of the given picture");
        }
        for (int i = 0; i < seam.length; i++) {
            if (seam[i] < 0 || seam[i] >= width()) {
                throw new IllegalArgumentException("The entry in seam is not in range 0 to the width of the given picture");
            }
            if (Math.abs(seam[i] - seam[i+1]) > 1) {
                throw new IllegalArgumentException("The differ between two adjacent entries more than 1");
            }
        }
        shiftPicture(seam);
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        if (pic.height() <= 1) {
            throw new IllegalArgumentException("The height of given picture is less than or equal to 1");
        }
        if (seam == null) {
            throw new IllegalArgumentException("Given a null seam object");
        }
        if (seam.length != width()) {
            throw new IllegalArgumentException("The length of the seam not math the height of the given picture");
        }
        for (int i = 0; i < seam.length; i++) {
            if (seam[i] < 0 || seam[i] >= height()) {
                throw new IllegalArgumentException("The entry in seam is not in range 0 to the width of the given picture");
            }
            if (Math.abs(seam[i] - seam[i+1]) > 1) {
                throw new IllegalArgumentException("The differ between two adjacent entries more than 1");
            }
        }
    }

    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        SeamCarver sc = new SeamCarver(pic);
        sc.picture().show();
        sc.rotatedPic.show();
    }
}
