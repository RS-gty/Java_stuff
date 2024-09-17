package figure;

import linalg.Vector3d;

import java.awt.*;

public class LineFigure extends Figure {
    public double x1,y1,z1 ;
    public Vector3d end_position ;

    public LineFigure(Vector3d origin, Vector3d end, double radius) {
        this.position = origin;
        this.end_position = end;
        this.x = position.x;
        this.y = position.y;
        this.z = position.z;
        this.x1 = end_position.x;
        this.y1 = end_position.y;
        this.z1 = end_position.z;
        this.radius = radius;
        this.tag = "linefigure";
    }

    @Override
    public LineFigure register(FigureSet set) {
        set.add(this,"linefigure");
        return this;
    }
}
