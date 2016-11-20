package geometry;

/**
 * Created by coand on 10/23/2016.
 */
public class Vector {

    private static final double EPSILON = 0.000001d;

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

    public boolean doesIntersect(Triangle triangle) {
        Point[] vertices = triangle.getVertices();
        Point v1 = vertices[0];
        Point v2 = vertices[1];
        Point v3 = vertices[2];
        Point O = Point.centerOf(vertices);

        // Moller-Trumbore intersection
        Vector edge1, edge2;
        Vector P, Q, T;
        double det, inv_det, u, v, t;

        //Find vectors for two edges sharing V1
        edge1 = v2.minus(v1);
        edge2 = v3.minus(v1);

        //Begin calculating determinant - also used to calculate u parameter
        P = this.crossProduct(edge2);

        //if determinant is near zero, ray lies in plane of triangle or ray is parallel to plane of triangle
        det = edge1.dotProduct(P);

        //NOT CULLING
        if(det > -EPSILON && det < EPSILON) return false;
        inv_det = 1.f / det;

        //calculate distance from V1 to ray origin
        T = getOrigin().minus(v1);

        //Calculate u parameter and test bound
        u = T.dotProduct(P) * inv_det;

        //The intersection lies outside of the triangle
        if(u < 0.f || u > 1.f) return false;

        Q = T.crossProduct(edge1);

        //Calculate V parameter and test bound
        v = this.dotProduct(Q) * inv_det;

        //The intersection lies outside of the triangle
        if(v < 0.f || u + v  > 1.f) return false;

        t = edge2.dotProduct(Q) * inv_det;

        return t > EPSILON;
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

    public double dotProduct(Vector b) {
        Vector a = this;
        return a.getX() * b.getX() + a.getY() + b.getY() + a.getZ() * b.getZ();
    }

    @Override
    public String toString() {
        return "[" + this.getX() + ", " + this.getY() + ", " + this.getZ() + "]";
    }

}
