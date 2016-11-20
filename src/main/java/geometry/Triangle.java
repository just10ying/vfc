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

    public Point getCenter() {
        return Point.centerOf(vertices);
    }

    public boolean equals(Triangle other) {
        if (!this.normal.equals(other.normal)) return false;
        for (int index = 0; index < vertices.length; index++) {
            if (!this.vertices[index].equals(other.vertices[index])) {
                return false;
            }
        }
        return true;
    }

    public double area() {
        Vector ab = vertices[1].minus(vertices[0]);
        Vector ac = vertices[2].minus(vertices[0]);
        return .5 * ab.magnitude() * ab.magnitude() * Math.sin(ab.angleBetween(ac));
    }

}
