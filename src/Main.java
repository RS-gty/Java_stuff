import camera.Camera;
import data.enums;
import linalg.Vector3d;
import linalg.matrix.RotationMatrix3d;

public class Main {
    public static void main(String[] args) {
        Camera camera = new Camera(new Vector3d(0, 0, 0), 1, 1, 1);
        Vector3d v = new Vector3d(1, 1, 0);
        long stime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            camera.isVisible(v);
        }
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));
    }
}