package geometry;

import org.junit.Before;
import org.junit.Test;

/**

import org.junit.Test;

/**
 * Created by coand on 11/20/2016.
 */

public class MollerTrumboreTests {

    private static final Vector RAY_BELOW_ORIGIN_1 = new Vector();

    private static final Triangle TRIANGLE_ABOVE_ORIGIN_1 = new Triangle();
    private static final Triangle TRIANGLE_FAR_FROM_ORIGIN_1 = new Triangle();

    @Before
    public void setup() {
        RAY_BELOW_ORIGIN_1.setOrigin(new Point(new double[] {0, 0, -1}));
        RAY_BELOW_ORIGIN_1.setValues(new double[] {0, 0, 2});

        Point[] triangleAboveOriginVertices = {new Point(new double[] {1,0,0}), new Point(new double[] {-1,1,0}),
                new Point(new double[] {-1,-1,0})};
        TRIANGLE_ABOVE_ORIGIN_1.setVertices(triangleAboveOriginVertices);

        Point[] triangleFarFromOriginVertices = {
                new Point(new double[] {1000, 1000, 1000}),
                new Point(new double[] {2000, 2000, 2000}),
                new Point(new double[] {1000, -2000, 2000})
        };
        TRIANGLE_FAR_FROM_ORIGIN_1.setVertices(triangleFarFromOriginVertices);
    }

    @Test
    public void rayBelowOrigin_shouldIntersectDirectlyAboveTriangle() {
        assert RAY_BELOW_ORIGIN_1.doesIntersect(TRIANGLE_ABOVE_ORIGIN_1);
    }

    @Test
    public void rayBelowOrigin_shouldNotIntersectFarAwayTriangle() {
        assert !RAY_BELOW_ORIGIN_1.doesIntersect(TRIANGLE_FAR_FROM_ORIGIN_1);
    }

    @Test
    public void danTub_shouldBeNub() {
        assert true;
    }
//
//    public static void main(String[] args) {
//        // TEST 1: All zeroes?
//        System.out.println("Test 1:");
//        // Triangle 1
//        Triangle test1_tri = new Triangle();
//        Point[] test1_pts = {new Point(new double[] {10,-1,1}), new Point(new double[] {-1,10,1}),
//                new Point(new double[] {-1,-1,1})};
//        test1_tri.setVertices(test1_pts);
//        Point[] test1_vtx = test1_tri.getVertices();
//        System.out.println("triangle vertices: " + test1_vtx[0] + ", " + test1_vtx[1] + ", " + test1_vtx[2]);
//        // Vector 1
//        Vector test1_vec = new Vector();
//        test1_vec.setOrigin(new Point(new double[] {0,0,0})); // below triangle
//        test1_vec.setX(0);
//        test1_vec.setY(0);
//        test1_vec.setZ(1);
//        System.out.println("vector: " + test1_vec.getOrigin() + ", " + test1_vec);
//        // Test
//        boolean test1_intersect = test1_vec.doesIntersect(test1_tri);
//        System.out.println("intersection: " + test1_intersect);
//        System.out.println();
//
//        // TEST 2: Third check fails
//        System.out.println("Test 2:");
//        // Triangle 2
//        Triangle test2_tri = new Triangle();
//        Point[] test2_pts = {new Point(new double[] {1,0,0}), new Point(new double[] {-1,1,0}),
//                new Point(new double[] {-1,-1,0})};
//        test2_tri.setVertices(test2_pts);
//        Point[] test2_vtx = test2_tri.getVertices();
//        System.out.println("triangle vertices: " + test2_vtx[0] + ", " + test2_vtx[1] + ", " + test2_vtx[2]);
//        // Vector 2
//        Vector test2_vec = new Vector();
//        test2_vec.setOrigin(new Point(new double[] {0,-1,-1})); // below triangle
//        test2_vec.setX(0);
//        test2_vec.setY(0);
//        test2_vec.setZ(2);
//        System.out.println("vector: " + test2_vec.getOrigin() + ", " + test2_vec);
//        // Test; ought to intersect
//        boolean test2_intersect = test2_vec.doesIntersect(test2_tri);
//        System.out.println("intersection: " + test2_intersect);
//        System.out.println();
//    }
}
