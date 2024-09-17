import camera.Camera;
import data.enums;
import figure.Dot;
import figure.FigureSet;
import linalg.Vector3d;
import linalg.matrix.Matrix3d;
import linalg.matrix.RotationMatrix3d;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Camera camera = new Camera(new Vector3d(0, 0, 0), 0, 0 , 0);
        Vector3d v = new Vector3d(1, 0, 0);
        FigureSet figureSet = new FigureSet();
        long stime = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            System.out.printf(Arrays.toString(camera.getRelativePosition(v)));
        }
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));
    }
}