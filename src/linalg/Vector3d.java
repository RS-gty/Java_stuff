package linalg;

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
}
