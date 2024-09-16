package camera;

import data.enums;
import linalg.Vector3d;
import linalg.matrix.Matrix3d;
import linalg.matrix.RotationMatrix3d;

public class Camera {
    public Vector3d position;
    public double yaw, pitch, roll;
    public double fov;

    public RotationMatrix3d rotation = new RotationMatrix3d().setRotationAxis(enums.Axis.X).setRotationAngle(1);
    public Matrix3d matrix = rotation;
}
