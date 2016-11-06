import geometry.Point;
import geometry.Triangle;
import geometry.Vector;
import org.j3d.loaders.InvalidFormatException;
import org.j3d.loaders.stl.STLFileReader;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by coand on 10/23/2016.
 */
public class GeometryLoader {

    private STLFileReader reader;

    private double[] normal = new double[3];
    private double[][] vertices = new double[3][3];

    public GeometryLoader(File file) {
        try {
            reader = new STLFileReader(file);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public Iterator<Triangle> load() {
        return new Iterator<Triangle>() {
            public boolean hasNext() {
                return false;
            }

            public Triangle next() {
                if (reader == null) return null;

                try {
                    Triangle facet = new Triangle();

                    reader.getNextFacet(normal, vertices);
                    Point[] pointVertices = new Point[vertices.length];
                    for (int dim = 0; dim < vertices.length; dim++) {
                        pointVertices[dim] = new Point(vertices[dim]);
                    }
                    facet.setVertices(pointVertices);

                    Point center = Point.centerOf(pointVertices);
                    Vector normalVector = new Vector();
                    normalVector.setValues(normal);
                    normalVector.setOrigin(center);

                    facet.setNormal(normalVector);

                    return facet;
                } catch (InvalidFormatException | IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public void remove() {}
        };
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
