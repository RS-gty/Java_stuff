package camera;

import data.enums;
import linalg.Vector3d;
import linalg.matrix.Matrix3d;
import linalg.matrix.RotationMatrix3d;

public class Camera {
    public Vector3d position;
    public double yaw, pitch, roll;
    public double Wfov, Hfov;
    public double[] ratio;

    /* Default target vector : (1, 0, 0) */
    public RotationMatrix3d yaw_rotation;
    public RotationMatrix3d pitch_rotation;
    public RotationMatrix3d roll_rotation;

    public Camera(){
        position = new Vector3d(0,0,0);
        yaw = 0;
        pitch = 0;
        roll = 0;
        Wfov = 100*Math.PI/180;
        Hfov = 100*Math.PI/180;
        ratio = new double[]{16, 9};
        this.yaw_rotation = new RotationMatrix3d().setRotationAxis(enums.Axis.Z).setRotationAngle(-yaw);
        this.pitch_rotation = new RotationMatrix3d().setRotationAxis(enums.Axis.Y).setRotationAngle(-pitch);
        this.roll_rotation = new RotationMatrix3d().setRotationAxis(enums.Axis.X).setRotationAngle(-roll);
    }
    public Camera(Vector3d position, double yaw, double pitch, double roll, double Wfov,double Hfov, double[] ratio){
        this.position = position;
        this.yaw = yaw;
        this.pitch = pitch;
        this.roll = roll;
        this.Wfov = Wfov;
        this.Hfov = Hfov;
        this.ratio = ratio;
        this.yaw_rotation = new RotationMatrix3d().setRotationAxis(enums.Axis.Z).setRotationAngle(-yaw);
        this.pitch_rotation = new RotationMatrix3d().setRotationAxis(enums.Axis.Y).setRotationAngle(-pitch);
        this.roll_rotation = new RotationMatrix3d().setRotationAxis(enums.Axis.X).setRotationAngle(-roll);
    }
    public Camera(Vector3d position){
        this.position = position;
        this.yaw = 0;
        this.pitch = 0;
        this.roll = 0;
        this.Wfov = 100*Math.PI/180;
        this.Hfov = 100*Math.PI/180;
        ratio = new double[]{16, 9};
        this.yaw_rotation = new RotationMatrix3d().setRotationAxis(enums.Axis.Z).setRotationAngle(-yaw);
        this.pitch_rotation = new RotationMatrix3d().setRotationAxis(enums.Axis.Y).setRotationAngle(-pitch);
        this.roll_rotation = new RotationMatrix3d().setRotationAxis(enums.Axis.X).setRotationAngle(-roll);
    }
    public Camera(Vector3d position, double yaw, double pitch, double roll){
        this.position = position;
        this.yaw = yaw;
        this.pitch = pitch;
        this.roll = roll;
        this.Wfov = 100*Math.PI/180;
        this.Hfov = 100*Math.PI/180;
        ratio = new double[]{16, 9};
        this.yaw_rotation = new RotationMatrix3d().setRotationAxis(enums.Axis.Z).setRotationAngle(-yaw);
        this.pitch_rotation = new RotationMatrix3d().setRotationAxis(enums.Axis.Y).setRotationAngle(-pitch);
        this.roll_rotation = new RotationMatrix3d().setRotationAxis(enums.Axis.X).setRotationAngle(-roll);
    }

    public boolean isVisible(Vector3d Tposition){
        Vector3d reVector = Tposition.sub(position);
        reVector = this.roll_rotation.multiply(this.pitch_rotation.multiply(this.yaw_rotation.multiply(reVector)));
        double width  = reVector.x * Math.tan(Wfov / 2);
        return (width >= Math.abs(reVector.y) && width * (ratio[1] / ratio[0]) >= Math.abs(reVector.z));
    }

    public double[] getRelativePosition(Vector3d Tposition){
        Vector3d reVector = Tposition.sub(position);
        reVector = this.roll_rotation.multiply(this.pitch_rotation.multiply(this.yaw_rotation.multiply(reVector)));
        if (reVector.x > 0) {
            double width = reVector.x * Math.tan(Wfov / 2);
            double height = reVector.y * Math.tan(Wfov / 2);
            return new double[]{reVector.y / width, reVector.z / width * (ratio[1] / ratio[0])};
        } else{
            return null;
        }
    }
}
