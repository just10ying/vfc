package geometry;

/**
 * Created by coand on 10/23/2016.
 */
public class Triangle {

    private Point[] vertices = new Point[3];
    private Vector normal;

    public Triangle() {}

    public Point[] getVertices() {
        return vertices;
    }

    public void setVertices(Point[] vertices) {
        this.vertices = vertices;
    }

    public Vector getNormal() {
        return normal;
    }

    public void setNormal(Vector normal) {
        this.normal = normal;
    }

}
