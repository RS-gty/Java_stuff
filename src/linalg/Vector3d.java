package linalg;

import figure.Dot;

public class Vector3d {
    public double x;
    public double y;
    public double z;
    public double[] array = new double[3];

    public Vector3d(double px, double py, double pz) {
        x = px;
        y = py;
        z = pz;
        array[0] = x;
        array[1] = y;
        array[2] = z;
    }
    public Vector3d(double[] p) {
        if (p.length == 3) {
            x = p[0];
            y = p[1];
            z = p[2];
            array = p;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    public Vector3d(Dot origin, Dot end) {
        x = end.x - origin.x;
        y = end.y - origin.y;
        z = end.z - origin.z;
        array[0] = x;
        array[1] = y;
        array[2] = z;
    }
    public double norm(){
        return Math.sqrt(x*x + y*y + z*z);
    }

    public Vector3d add(Vector3d p) {
        return new Vector3d(x + p.x, y + p.y, z + p.z);
    }

    public Vector3d sub(Vector3d p) {
        return new Vector3d(x - p.x, y - p.y, z - p.z);
    }

    public Vector3d mul(double p) {
        return new Vector3d(x * p, y * p, z * p);
    }

    public Vector3d div(double p) {
        return new Vector3d(x / p, y / p, z / p);
    }

    public double dot(Vector3d p) {
        return this.x * p.x + this.y * p.y + this.z * p.z;
    }

    public Vector3d cross(Vector3d p) {
        return new Vector3d(this.y*p.z-this.z*p.y, -this.x-p.z+this.z*p.x, this.x*p.y-this.y*p.x);
    }

    public Vector3d random(double range){
        return new Vector3d(Math.random()*range, Math.random()*range, Math.random()*range);
    }

    public Vector3d normalize() {
        return new Vector3d(x / this.norm(), y / this.norm(), z / this.norm());
    }
}
