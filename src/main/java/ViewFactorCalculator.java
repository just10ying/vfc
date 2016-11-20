import geometry.Point;
import geometry.Triangle;
import geometry.Vector;

import java.io.File;
import java.util.Iterator;

/**
 * Created by coand on 11/6/2016.
 */
public class ViewFactorCalculator {

    private static final double PI = 3.141592653589793238462643383279502884197169399375105820974944592307816406286;

    public static void main(String[] args) {
        String emittersFileName = args[0];
        String receiversFileName = args[1];
        String solidsFileName = args[2];

        Iterator<Triangle> emitters = new GeometryLoader(new File(emittersFileName)).load();

        double viewFactor = 0;

        while (emitters.hasNext()) {
            Triangle emitter = emitters.next();
            Iterator<Triangle> receivers = new GeometryLoader(new File(receiversFileName)).load();
            while (receivers.hasNext()) {
                Triangle receiver = receivers.next();

                Vector ray = receiver.getCenter().minus(emitter.getCenter());

                Iterator<Triangle> solids = new GeometryLoader(new File(solidsFileName)).load();
                boolean blocked = false;
                while (solids.hasNext()) {
                    Triangle solid = solids.next();
                    if (ray.doesIntersect(solid) && !solid.equals(emitter) && !solid.equals(receiver)) {
                        blocked = true;
                        break;
                    }
                }

                if (!blocked) {
                    viewFactor += calculateViewFactor(emitter, receiver);
                }
            }
        }

        System.out.println(viewFactor);
    }

    public static double calculateViewFactor(Triangle origin, Triangle destination) {
        Vector ray = destination.getCenter().minus(origin.getCenter());

        return (1 / origin.area()) *
                Math.cos(ray.angleBetween(origin.getNormal())) *
                Math.cos(ray.angleBetween(destination.getNormal())) *
                origin.area() *
                destination.area() *
                (1 / PI) * (1 / (ray.magnitude() * ray.magnitude()));
    }

}
