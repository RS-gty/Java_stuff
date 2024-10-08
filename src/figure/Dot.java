package figure;

import linalg.Vector3d;

import java.lang.Math;

public class Dot extends Figure {
    public String tag;
    public Dot(Vector3d position, double radius){
        this.position = position;
        this.x = position.x;
        this.y = position.y;
        this.z = position.z;
        this.radius = radius;
        this.tag = "dot";
    }

    public Dot(double px, double py, double pz, double radius) {
        this.x = px;
        this.y = py;
        this.z = pz;
        this.position = new Vector3d(x, y, z);
        this.radius = radius;
    }

    public double getDistance() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    @Override
    public Dot register(FigureSet set) {
        set.add(this, "dot");
        return this;
    }
}
