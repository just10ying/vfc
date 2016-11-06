package geometry;

/**
 * Created by coand on 10/23/2016.
 */
public class Vector {

    private Point origin;
    private double x, y, z;

    public Vector() {

    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
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

    public void setValues(double[] values) {
        this.x = values[0];
        this.y = values[1];
        this.z = values[2];
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2) + Math.pow(getZ(), 2));
    }

    public Vector crossProduct(Vector b) {
        Vector a = this;
        Vector result = new Vector();
        result.setX((a.getY() * b.getZ()) - (a.getZ() * b.getY()));
        result.setY((a.getZ() * b.getX()) - (a.getX() * b.getZ()));
        result.setZ((a.getX() * b.getY()) - (a.getY() * b.getX()));
        result.setOrigin(a.getOrigin());
        return result;
    }

    @Override
    public String toString() {
        return this.getX() + ", " + this.getY() + ", " + this.getZ();
    }

}
