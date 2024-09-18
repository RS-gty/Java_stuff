package figure;

import linalg.Vector3d;

public class TriangleFigure extends PolygonFigure {

    public TriangleFigure(Dot[] dots) {
        super(dots);
        if (dots.length == 3) {
            this.normal_vector = new Vector3d(this.Dots[0], this.Dots[1]).cross(new Vector3d(this.Dots[0], this.Dots[2])).normalize();
        } else{
            throw new IllegalArgumentException("Triangle figure requires three dots");
        }
    }



    public boolean isVisiable(Vector3d origin, Vector3d destin){
        Vector3d s1 = origin.add(this.normal_vector.mul(new Vector3d(new Dot(origin, 1), this.Dots[0]).dot(this.normal_vector)));
        Vector3d s2 = destin.add(this.normal_vector.mul(new Vector3d(new Dot(destin, 1), this.Dots[0]).dot(this.normal_vector)));

    }
}
