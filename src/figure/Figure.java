package figure;

import linalg.Vector3d;

public abstract class Figure {
    public double x,y,z ;
    public Vector3d position ;
    public String tag = "figure";

    public Figure(){
    }

    public Figure register(FigureSet set) {
        set.add(this,"figure");
        return this;
    }
}
