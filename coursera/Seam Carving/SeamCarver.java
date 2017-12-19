import edu.princeton.cs.algs4.Picture;

public class SeamCarver {

    private final Picture pic;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException("Given a null picture object");
        }
        this.pic = picture;
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

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        if (x < 0 || x >= width()) {
            throw new IllegalArgumentException("Given x is not in range");
        }
        if (y < 0 || y >= height()) {
            throw new IllegalArgumentException("Given y is not in range");
        }

        return 0.0;
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        return null;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        return null;
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        if (pic.height() <= 1) {
            throw new IllegalArgumentException("The height of given picture is less than or equal to 1");
        }
        if (seam == null) {
            throw new IllegalArgumentException("Given a null seam object");
        }
        if (seam.length != pic.height()) {
            throw new IllegalArgumentException("The length of the seam not math the height of the given picture");
        }
        for (int i = 0; i < seam.length; i++) {
            if (seam[i] < 0 || seam[i] >= width()) {
                throw new IllegalArgumentException("The entry in seam is not in range 0 to the width of the given picture");
            }
            if (Math.abs(seam[i] - seam[i+1]) > 1) {
                throw new IllegalArgumentException("The differ between two adjacent entries more than 1");
            }
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
        if (seam.length != pic.width()) {
            throw new IllegalArgumentException("The height of the seam not match the width of the given picture");
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

}
