import bezier.Bezier;
import bezier.Point;
import bezier.units.Inches;
import bezier.units.Seconds;
import bezier.units.derived.Acceleration;
import bezier.units.derived.LinearVelocity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BezierTest {
    @Test
    void horizTest() {
        var controlPoints = new ArrayList<Point>();
        controlPoints.add(new Point(0, 0, true));
        controlPoints.add(new Point(60, 0, true));

        var path = Bezier.generateSpline(controlPoints,
                new LinearVelocity<>(new Inches(120), new Seconds(1)),
                new Acceleration<>(new Inches(48), new Seconds(1)),
                new Seconds(.02),
                new Inches(29)
        );

        for (Point point : path) {
            System.out.println(point.getTargetVelocity() + "\n"
                    + point.getLeftVel() + "\n"
                    + point.getLeftPos() + "\n"
            );
        }
    }
}
