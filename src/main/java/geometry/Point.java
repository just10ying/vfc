package geometry;

/**
 * Created by coand on 10/23/2016.
 */
public class Point {

    private double x, y, z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(double[] coords) {
        this.x = coords[0];
        this.y = coords[1];
        this.z = coords[2];
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Vector minus(Point p) {
        Vector vect = new Vector();
        vect.setX(this.getX() - p.getX());
        vect.setY(this.getY() - p.getY());
        vect.setZ(this.getZ() - p.getZ());
        return vect;
    }

    public double distanceTo(Point p) {
        return this.minus(p).magnitude();
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + ")";
    }

    public static Point centerOf(Point[] points) {
        double x = 0, y = 0, z = 0;
        for (Point p : points) {
            x += p.getX();
            y += p.getY();
            z += p.getZ();
        }
        return new Point(x / points.length, y / points.length, z / points.length);
    }

}
