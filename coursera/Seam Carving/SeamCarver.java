import edu.princeton.cs.algs4.Picture;


import java.util.Arrays;
import java.awt.Color;
import java.util.Stack;


public class SeamCarver {

    private Picture pic;

    private int[] edgeTo;
    private double[] distTo;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException("Given a null picture object");
        }
        pic = new Picture(picture);
    }

    private Picture transpose(Picture p) {
        Picture res = new Picture(p.height(), p.width());
        for (int col = 0; col < res.width(); col++) {
            for (int row = 0; row < res.height(); row++) {
                Color current = p.get(row, col);
                res.set(col, row, current);
            }
        }
        return res;
    }

    private double[][] buildDistribution(Picture p) {
        double[][] res = new double[p.height()][p.width()];
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[0].length; col++) {
                res[row][col] = energy(col, row, p);
            }
        }
        return res;
    }

    // current picture
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

    private boolean onBoard(int x, int y, Picture p) {
        return (x == 0 || x == p.width() - 1 || y == 0 || y == p.height() - 1);
    }

    private double energy(int x, int y, Picture p) {
        if (x < 0 || x >= p.width()) {
            throw new IllegalArgumentException("Given x is not in range");
        }
        if (y < 0 || y >= p.height()) {
            throw new IllegalArgumentException("Given y is not in range");
        }

        if (onBoard(x, y, p)) {
            return 1000;
        } else {
            Color left = p.get(x - 1, y);
            Color right = p.get(x + 1, y);
            Color upper = p.get(x, y - 1);
            Color down = p.get(x, y + 1);

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

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        return energy(x, y, pic);
    }

    private boolean checkRange(int x, double[][] dist) {
        int width = dist[0].length;

        return x >= 0 && x < width;
    }

    private int xyTo1D(int row, int col, double[][] dist) {
        int width = dist[0].length;

        return row * width + col;
    }

    private int[] get2D(int idx, double[][] dist) {
        int width = dist[0].length;

        int col = idx % width;
        int row = (idx - col) / width;

        return new int[]{row, col};
    }

    private void relax(int from, int to, double[][] dist) {
        int[] idx = get2D(to, dist);
        int row = idx[0];
        int col = idx[1];
        if (distTo[to] > distTo[from] + dist[row][col]) {
            distTo[to] = distTo[from] + dist[row][col];
            edgeTo[to] = from;
        }
    }

    private void topologicalSP(double[][] dist) {

        int size = dist.length * dist[0].length;
        edgeTo = new int[size];
        distTo = new double[size];

        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        for (int i = 0; i < dist[0].length; i++) {
            edgeTo[i] = -1;
            distTo[i] = dist[0][i];
        }

        for (int row = 1; row < dist.length; row++) {
            for (int col = 0; col < dist[0].length; col++) {
                int prevRow = row - 1;
                int[] candidates = new int[] {col, col - 1, col + 1};
                for (int c: candidates) {
                    if (checkRange(c, dist)) {
                        int from = xyTo1D(prevRow, c, dist);
                        int to = xyTo1D(row, col, dist);
                        relax(from, to, dist);
                    }
                }
            }
        }
    }

    private int argmin(double[] array) {
        double min = Double.POSITIVE_INFINITY;
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                res = i;
            }
        }
        return res;
    }

    private int[] findVerticalSeamAux(double[][] dist) {
        topologicalSP(dist);
        int start = xyTo1D(dist.length - 1, 0, dist);
        double[] lowest = Arrays.copyOfRange(distTo, start, distTo.length);

        int target = argmin(lowest);
        Stack<Integer> st = new Stack<>();
        st.push(target);
        for (int from = edgeTo[target + (dist.length - 1) * dist[0].length]; from != -1; from = edgeTo[from]) {
            int[] idx = get2D(from, dist);
            st.push(idx[1]);
        }

        int[] res = new int[st.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = st.pop();
        }

        return res;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        double[][] distribution = buildDistribution(pic);
        return findVerticalSeamAux(distribution);
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        Picture transposed = transpose(pic);
        double[][] rotated = buildDistribution(transposed);
        return findVerticalSeamAux(rotated);
    }

    private void verticalShiftPicture(Picture p, int[] seam) {
        Picture picture = new Picture(p.width() - 1, p.height());
        for (int row = 0; row < picture.height(); row++) {
            int split = seam[row];
            for (int col = 0; col < split; col++) {
                Color copy = p.get(col, row);
                picture.set(col, row, copy);
            }
            for (int col = split; col < picture.width(); col++) {
                Color copy = p.get(col+1, row);
                picture.set(col, row, copy);
            }
        }
        this.pic = picture;
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
        verticalShiftPicture(pic, seam);
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
        Picture transposed = transpose(pic);

        pic = transpose(transposed);
    }
}
