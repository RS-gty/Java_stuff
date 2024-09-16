import data.enums;
import linalg.Vector3d;
import linalg.matrix.RotationMatrix3d;

public class Main {
    public static void main(String[] args) {
        RotationMatrix3d rotation = new RotationMatrix3d().setRotationAxis(enums.Axis.X).setRotationAngle(Math.PI / 2);
        Vector3d v = new Vector3d(1, 1, 0);
        System.out.println(rotation.multiply(v).array[2]);
    }
}