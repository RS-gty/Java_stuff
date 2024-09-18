package figure;

import figure.*;
import linalg.Vector3d;

public class PolygonFigure extends Figure {
    public double[] xPoints = new double[0], yPoints = new double[0];
    public Dot[] Dots;
    public int length = 0;
    public double[] def_color = {Math.random(), Math.random(), Math.random()};
    public Vector3d normal_vector;

    public PolygonFigure(Dot[] dots) {
        for (Dot dot : dots) {
            double[] newXPoints = new double[length+1];
            double[] newYPoints = new double[length+1];
            System.arraycopy(xPoints, 0, newXPoints, 0, length);
            System.arraycopy(yPoints, 0, newYPoints, 0, length);
            newXPoints[length] = dot.x;
            newYPoints[length] = dot.y;
            xPoints = newXPoints;
            yPoints = newYPoints;
            this.length = length+1;
        }
        this.Dots = dots;
    }

    @Override
    public PolygonFigure register(FigureSet set) {
        set.add(this,"polygonfigure");
        return this;
    }
}
