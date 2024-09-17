package figure;

import linalg.Vector3d;

import java.lang.Math;

public class Dot extends Figure {
    public String tag;

    public Dot(Vector3d position){
        this.position = position;
        this.x = position.x;
        this.y = position.y;
        this.z = position.z;
        this.tag = "dot";
    }

    public Dot(double px, double py, double pz) {
        this.x = px;
        this.y = py;
        this.z = pz;
        this.position = new Vector3d(x, y, z);
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
