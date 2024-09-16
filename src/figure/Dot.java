package figure;

import java.lang.Math;

public class Dot {
    public int x,y,z ;

    public Dot(int px, int py, int pz) {
        this.x = px;
        this.y = py;
        this.z = pz;
    }

    public double getDistance() {
        return Math.sqrt(x*x + y*y + z*z);
    }
}
